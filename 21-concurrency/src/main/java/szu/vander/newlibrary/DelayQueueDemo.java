package szu.vander.newlibrary;

//: concurrency/DelayQueueDemo.java
import java.util.concurrent.*;
import java.util.*;
import static java.util.concurrent.TimeUnit.*;
import static szu.vander.util.Print.*;

/**
 * 
* @author      : caiwj
* @date        : 2019-02-16
* @description ： Delayed接口有一个方法getDelay(0，用来告知延时时间多长，这个方法强制我们使用TimeUnit类，因为这就是它的参数类型。
* 				可以用TimeUnit来很容易的实现时间单元的转化。（NANOSECONDS.convert(delta, MILLISECONDS)）
* 				为了对延期时间进行排序，Delayed接口还继承了Comparable接口，因此必须实现compareTo()，toString和summary
* 				提供了输出格式化，嵌套的EndSentinel类提供了一种关闭所有事物的途径，具体做法是将其放置为队列的最后一个元素。
* 				 从输出可以看出，任务创建的顺序对执行顺序没有任何影响，任务是按照所期望的延迟顺序执行的。
 */
class DelayedTask implements Runnable, Delayed {
	private static int counter = 0;
	private final int id = counter++;
	// 延迟时间，延迟时间小的优先执行
	private final int delta;
	private final long trigger;
	// sequence维护延时任务的创建顺序
	protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();

	public DelayedTask(int delayInMilliseconds) {
		delta = delayInMilliseconds;
		// 将毫秒转化为纳秒
		// nano-纳 micro-微 mill-毫
		trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
		sequence.add(this);
	}

	public long getDelay(TimeUnit unit) {
		return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
	}

	// 实现compareTo方法告诉DelayQueue应该以怎样比较大小排序 
	public int compareTo(Delayed arg) {
		DelayedTask that = (DelayedTask) arg;
		if (trigger < that.trigger)
			return -1;
		if (trigger > that.trigger)
			return 1;
		return 0;
	}

	public void run() {
		printnb(this + " ");
	}

	public String toString() {
		return String.format("[%1$-4d]", delta) + " Task " + id;
	}

	public String summary() {
		return "(" + id + ":" + delta + ")";
	}

	// 提供了一种关闭事物的途径，具体做法是将其放置在队列的最后一个元素
	public static class EndSentinel extends DelayedTask {
		private ExecutorService exec;

		public EndSentinel(int delay, ExecutorService e) {
			super(delay);
			exec = e;
		}

		public void run() {
			for (DelayedTask pt : sequence) {
				printnb(pt.summary() + " ");
			}
			print();
			print(this + " Calling shutdownNow()");
			exec.shutdownNow();
		}
	}
}

class DelayedTaskConsumer implements Runnable {
	private DelayQueue<DelayedTask> q;

	public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
		this.q = q;
	}

	public void run() {
		try {
			while (!Thread.interrupted())
				q.take().run(); // Run task with the current thread
		} catch (InterruptedException e) {
			// Acceptable way to exit
		}
		print("Finished DelayedTaskConsumer");
	}
}

public class DelayQueueDemo {
	public static void main(String[] args) {
		Random rand = new Random(47);
		ExecutorService exec = Executors.newCachedThreadPool();
		DelayQueue<DelayedTask> queue = new DelayQueue<DelayedTask>();
		// Fill with tasks that have random delays:
		for (int i = 0; i < 20; i++)
			queue.put(new DelayedTask(rand.nextInt(5000)));
		// Set the stopping point
		queue.add(new DelayedTask.EndSentinel(5000, exec));
		exec.execute(new DelayedTaskConsumer(queue));
	}
} /*
	 * Output: [128 ] Task 11 [200 ] Task 7 [429 ] Task 5 [520 ] Task 18 [555 ] Task
	 * 1 [961 ] Task 4 [998 ] Task 16 [1207] Task 9 [1693] Task 2 [1809] Task 14
	 * [1861] Task 3 [2278] Task 15 [3288] Task 10 [3551] Task 12 [4258] Task 0
	 * [4258] Task 19 [4522] Task 8 [4589] Task 13 [4861] Task 17 [4868] Task 6
	 * (0:4258) (1:555) (2:1693) (3:1861) (4:961) (5:429) (6:4868) (7:200) (8:4522)
	 * (9:1207) (10:3288) (11:128) (12:3551) (13:4589) (14:1809) (15:2278) (16:998)
	 * (17:4861) (18:520) (19:4258) (20:5000) [5000] Task 20 Calling shutdownNow()
	 * Finished DelayedTaskConsumer
	 */// :~
