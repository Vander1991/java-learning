package szu.vander.basicthreading.thread;

import szu.vander.basicthreading.task.LiftOff;

//: concurrency/MoreBasicThreads.java
// Adding more threads.

/**
 * 
* @author      : Vander
* @date        : 2019-01-15
* @description ： 输出说明不同任务的执行在线程被换进换出时混在一起，这种交换是由线程调度器自动控制的，如果再你的机器上有多个处理
* 				器，线程调度器将会在这些处理器之间默默地分发线程。
* 				  输出结果会跟JDK版本有关，早期版本的JDK不会频繁对时间切片，因此线程一会一直执行，然后是线程二...较晚的JDK看起来
* 				会产生更好的切片行为，每个线程看起来都会获得更加正规的服务。
* 				 当main()创建Thread对象时，它并没有捕获任何对这些对象的引用，使用Thread时，每个Thread都“注册”了它自己，因此确实
* 				有一个对它的引用，而且在它的任务退出其run()并死亡之前，垃圾回收器无法清除它。所以在start完成之后，还能看到输出语句
 */
public class MoreBasicThreads {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new LiftOff()).start();
		}
		System.out.println("Waiting for LiftOff");
	}
} /*
	 * Output: (Sample) Waiting for LiftOff #0(9), #1(9), #2(9), #3(9), #4(9),
	 * #0(8), #1(8), #2(8), #3(8), #4(8), #0(7), #1(7), #2(7), #3(7), #4(7), #0(6),
	 * #1(6), #2(6), #3(6), #4(6), #0(5), #1(5), #2(5), #3(5), #4(5), #0(4), #1(4),
	 * #2(4), #3(4), #4(4), #0(3), #1(3), #2(3), #3(3), #4(3), #0(2), #1(2), #2(2),
	 * #3(2), #4(2), #0(1), #1(1), #2(1), #3(1), #4(1), #0(Liftoff!), #1(Liftoff!),
	 * #2(Liftoff!), #3(Liftoff!), #4(Liftoff!),
	 */// :~
