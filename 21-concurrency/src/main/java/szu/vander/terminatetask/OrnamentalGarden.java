package szu.vander.terminatetask;

//: concurrency/OrnamentalGarden.java
import java.util.concurrent.*;
import java.util.*;
import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2019-02-06
* @description : 下面的程序是个仿真程序，你希望统计每天经过花园大门的任务，每个花园大门都有一个计数器（number统一每个进入大门的人的数目），count是计算
* 				所有经过大门的总人数，一共有5个大门。
* 				Main中开启了5个线程，每个线程执行时间都是3秒，每个线程对count和number加了1之后会睡0.1s，所以单个线程执行完之后number是增加到了30，
* 				所有线程执行完之后，tocal会变成150
* 				这里如果不调用Entrance.cancel直接调用exec.shutdown()会发现根本停不下来，调用Entrance.canceled就是main像所有的Entrance
* 				发送static cancel()消息，调用exec的shutdown()，之后调用awaitTermination方法等待每个任务结束。
* 				 在这里Entrance.canceled()是一个volatile标志，因为它只会被读取和复制（不会与其他域组合在一起被读取），所以不需要同步对其的访问，就
* 				可以安全地访问它（意思是这个cancel变量只是在这个类中被用到，而没有被其他对象所用到，所以直接用volatile就行了？）。
 */
class Count {
	private int count = 0;
	private Random rand = new Random(47);

	// Remove the synchronized keyword to see counting fail:
	// 把synchronized去掉，会让多线程同时来加，可能两个线程会读取到同一个值，然后去加1，这样就会出现加少了的情况。
	public synchronized int increment() {
		int temp = count;
		if (rand.nextBoolean()) // Yield half the time
			Thread.yield();
		return (count = ++temp);
	}

	public synchronized int value() {
		return count;
	}
}

class Entrance implements Runnable {
	private static Count count = new Count();
	private static List<Entrance> entrances = new ArrayList<Entrance>();
	private int number = 0;
	// Doesn't need synchronization to read:
	private final int id;
	// 这里没加volatile，从运行的结果上看也没什么区别
	private static volatile boolean canceled = false;

	// Atomic operation on a volatile field:
	public static void cancel() {
		canceled = true;
	}

	public Entrance(int id) {
		this.id = id;
		// Keep this task in a list. Also prevents
		// garbage collection of dead tasks:
		entrances.add(this);
	}

	public void run() {
		while (!canceled) {
			synchronized (this) {
				++number;
			}
			print(this + " Total: " + count.increment());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				print("sleep interrupted");
			}
		}
		print("Stopping " + this);
	}

	public synchronized int getValue() {
		return number;
	}

	public String toString() {
		return "Entrance " + id + ": " + getValue();
	}

	public static int getTotalCount() {
		return count.value();
	}

	public static int sumEntrances() {
		int sum = 0;
		for (Entrance entrance : entrances)
			sum += entrance.getValue();
		return sum;
	}
}

public class OrnamentalGarden {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new Entrance(i));
		// Run for a while, then stop and collect the data:
		TimeUnit.SECONDS.sleep(3);
		Entrance.cancel();
		exec.shutdown();
		if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
			print("Some tasks were not terminated!");
		print("Total: " + Entrance.getTotalCount());
		print("Sum of Entrances: " + Entrance.sumEntrances());
	}
} /*
	 * Output: (Sample) Entrance 0: 1 Total: 1 Entrance 2: 1 Total: 3 Entrance 1: 1
	 * Total: 2 Entrance 4: 1 Total: 5 Entrance 3: 1 Total: 4 Entrance 2: 2 Total: 6
	 * Entrance 4: 2 Total: 7 Entrance 0: 2 Total: 8 ... Entrance 3: 29 Total: 143
	 * Entrance 0: 29 Total: 144 Entrance 4: 29 Total: 145 Entrance 2: 30 Total: 147
	 * Entrance 1: 30 Total: 146 Entrance 0: 30 Total: 149 Entrance 3: 30 Total: 148
	 * Entrance 4: 30 Total: 150 Stopping Entrance 2: 30 Stopping Entrance 1: 30
	 * Stopping Entrance 0: 30 Stopping Entrance 3: 30 Stopping Entrance 4: 30
	 * Total: 150 Sum of Entrances: 150
	 */// :~
