package szu.vander.basicthreading.sleeping;

//: concurrency/SleepingTask.java
// Calling sleep() to pause for a while.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import szu.vander.basicthreading.task.LiftOff;
/**
 * 
* @author      : Vander
* @date        : 2019-01-15
* @description ： 影响任务应为的一种简单方法是调用sleep()，这将使任务终止执行给定的时间。
* 				SleepingTask的run方法会抛出异常，并且在run中被捕获，异常不能跨线程传播回main(0，所以必须在本地处理所有在任务
* 				内部产生的异常。
* 				 JDK5之后线程睡眠使用TimeUtil，TimeUtil还可以被用来执行转换。
* 				虽然这样能起到一定的控制任务执行的顺序，但是不能依赖于Sleep来控制，如果你需要控制任务执行的顺序，最好的方法是
* 				使用同步控制，或者在某些情况下，压根不使用线程，但是要编写自己的协作例程，这些例程将会按照指定的顺序在互相之前
* 				传递控制权。
 */
public class SleepingTask extends LiftOff {
	public void run() {
		try {
			while (countDown-- > 0) {
				System.out.print(status());
				// Old-style:
				// Thread.sleep(100);
				// Java SE5/6-style:
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.err.println("Interrupted");
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new SleepingTask());
		exec.shutdown();
	}
} /*
	 * Output: #0(9), #1(9), #2(9), #3(9), #4(9), #0(8), #1(8), #2(8), #3(8), #4(8),
	 * #0(7), #1(7), #2(7), #3(7), #4(7), #0(6), #1(6), #2(6), #3(6), #4(6), #0(5),
	 * #1(5), #2(5), #3(5), #4(5), #0(4), #1(4), #2(4), #3(4), #4(4), #0(3), #1(3),
	 * #2(3), #3(3), #4(3), #0(2), #1(2), #2(2), #3(2), #4(2), #0(1), #1(1), #2(1),
	 * #3(1), #4(1), #0(Liftoff!), #1(Liftoff!), #2(Liftoff!), #3(Liftoff!),
	 * #4(Liftoff!),
	 */// :~
