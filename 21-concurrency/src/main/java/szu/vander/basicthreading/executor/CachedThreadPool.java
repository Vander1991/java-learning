package szu.vander.basicthreading.executor;

//: concurrency/CachedThreadPool.java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import szu.vander.basicthreading.task.LiftOff;

/**
 * 
* @author      : Vander
* @date        : 2019-01-15
* @description ： LiftOff对象知道如何运行具体的任务，与命令模式一样，它暴露了要执行的单一方法（run方法）
* 				ExecutorService知道如何构建恰当的上下文执行Runnable对象。CachedThreadPool将为每个任务创建一个线程。
* 				单个Executor被用来创建和管理系统中的所有任务。对shutdown()方法的调用可以防止新任务被提交到这个Executor，
* 				当前线程将继续运行在shutdown()被调用之前提交的所有任务。这个程序将在Executor中的所有任务完成后尽快退出。
 */
public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
} /*
	 * Output: (Sample) #0(9), #0(8), #1(9), #2(9), #3(9), #4(9), #0(7), #1(8),
	 * #2(8), #3(8), #4(8), #0(6), #1(7), #2(7), #3(7), #4(7), #0(5), #1(6), #2(6),
	 * #3(6), #4(6), #0(4), #1(5), #2(5), #3(5), #4(5), #0(3), #1(4), #2(4), #3(4),
	 * #4(4), #0(2), #1(3), #2(3), #3(3), #4(3), #0(1), #1(2), #2(2), #3(2), #4(2),
	 * #0(Liftoff!), #1(1), #2(1), #3(1), #4(1), #1(Liftoff!), #2(Liftoff!),
	 * #3(Liftoff!), #4(Liftoff!),
	 */// :~
