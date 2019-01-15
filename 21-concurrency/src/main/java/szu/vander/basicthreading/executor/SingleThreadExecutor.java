package szu.vander.basicthreading.executor;

//: concurrency/SingleThreadExecutor.java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import szu.vander.basicthreading.task.LiftOff;

/**
 * 
* @author      : Vander
* @date        : 2019-01-15
* @description ： SingleThreadExecutor就像是线程数量为1的FixedThreadPool。这对于你希望在另一个线程中连续运行的任何事物（长期
* 				存活的任务）来说，都是很有用的，例如监听进入套接字连接的任务。它对于希望在线程中运行的短任务也同样很方便，例如
* 				更新本地或远程日志的小人物，或者是事件分发线程。
* 				 如果向SingleThreadExecutor提交了多个任务，那么这些任务将排队，每个任务都会在下一个任务开始之前运行结束，所有
* 				任务将使用相同的线程。
* 				  假设有大量的线程，他们运行的任务将使用文件系统，你可以用SingleThreadExecutor来运行这些线程，确保任意时刻在
* 				任何线程中都只有唯一的任务在运行。在这种方式中，不需要共享资源上处理同步（同步不会过度使用文件系统）。有时更好
* 				的解决方案是在资源上同步，但是SingleThreadExecutor可以让你省去只是为了维持某些事物的原型而进行的各种努力，
* 				通过序列化任务，可以消除对序列化对象的需求。
* 			
 */
public class SingleThreadExecutor {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++)
			exec.execute(new LiftOff());
		exec.shutdown();
	}
} /*
	 * Output: #0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1),
	 * #0(Liftoff!), #1(9), #1(8), #1(7), #1(6), #1(5), #1(4), #1(3), #1(2), #1(1),
	 * #1(Liftoff!), #2(9), #2(8), #2(7), #2(6), #2(5), #2(4), #2(3), #2(2), #2(1),
	 * #2(Liftoff!), #3(9), #3(8), #3(7), #3(6), #3(5), #3(4), #3(3), #3(2), #3(1),
	 * #3(Liftoff!), #4(9), #4(8), #4(7), #4(6), #4(5), #4(4), #4(3), #4(2), #4(1),
	 * #4(Liftoff!),
	 */// :~
