package szu.vander.basicthreading.executor;

//: concurrency/FixedThreadPool.java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import szu.vander.basicthreading.task.LiftOff;

/**
 * 
* @author      : Vander
* @date        : 2019-01-15
* @description ：将CachedThreadPool替换为不同类型的Executor，FixedThreadPool使用了有限的线程集来执行所提交的任务
* 				使用它可以一次性先执行代价高昂的线程分配，因而也可以限制线程的数量。这可以节省时间，因为不用为每个
* 				任务都固定地付出创建线程的开销。在事件驱动的系统中，需要线程的事件处理器，通过直接从Pool中获得线程，
* 				也可以尽快得到服务。
* 					而CachedThreadPool通常会创建与所需数量相同的线程，然后在它回收线程时停止创建新线程，因此它是
* 				合理的Executor的首选。只有当这种方式有问题的时候，才需要切换到FixedThreadPool
 */
public class FixedThreadPool {
	public static void main(String[] args) {
		// Constructor argument is number of threads:
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++)
			exec.execute(new LiftOff());
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
