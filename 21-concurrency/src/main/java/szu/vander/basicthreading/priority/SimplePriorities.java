package szu.vander.basicthreading.priority;

//: concurrency/SimplePriorities.java
// Shows the use of thread priorities.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author : Vander
 * @date : 2019-01-15
 * @description ： 线程的优先级将该线程的重要性传递给调度器，调度器会倾向于让优先权高的线程先执行，但是优先权低的也会执行（优先权
 *              不会导致死锁），优先级较低的仅仅是执行频率较低而已。在绝大多数时间里，所有线程都应该以默认的优先级运行，试图
 *              操作线程的优先级通常是一种错误。 Thread.currentThread()打印出来的线程池-线程id，优先级，线程的出处
 *              尽管JDK有10个优先级，但是它与多数操作系统系统都不能映射得很好，例如windows有7个优先级且不是固定的，Sun的Solaries
 *              有2的31次方个优先级，唯一可移植的是当调整优先级的时，使用MAX_PRIORITY、NORM_PRIORITY、MIN_PRIORITY
 *              	这里还要注意的是要在run里面设置优先级，不然线程还没有交给调度器，设置了也没用。
 */
public class SimplePriorities implements Runnable {
	private int countDown = 5;
	private volatile double d; // No optimization
	private int priority;

	public SimplePriorities(int priority) {
		this.priority = priority;
	}

	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}

	public void run() {
		Thread.currentThread().setPriority(priority);
		while (true) {
			// An expensive, interruptable operation:
			for (int i = 1; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double) i;
				if (i % 1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		exec.shutdown();
	}
} /*
	 * Output: (70% match) Thread[pool-1-thread-6,10,main]: 5
	 * Thread[pool-1-thread-6,10,main]: 4 Thread[pool-1-thread-6,10,main]: 3
	 * Thread[pool-1-thread-6,10,main]: 2 Thread[pool-1-thread-6,10,main]: 1
	 * Thread[pool-1-thread-3,1,main]: 5 Thread[pool-1-thread-2,1,main]: 5
	 * Thread[pool-1-thread-1,1,main]: 5 Thread[pool-1-thread-5,1,main]: 5
	 * Thread[pool-1-thread-4,1,main]: 5 ...
	 */// :~
