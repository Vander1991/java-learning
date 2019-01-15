package szu.vander.basicthreading.thread;

import szu.vander.basicthreading.task.LiftOff;

//: concurrency/BasicThreads.java
// The most basic use of the Thread class.

/**
 * 
* @author      : Vander
* @date        : 2019-01-15
* @description ：将Runnable对象转变为工作任务的传统方式是将它提交给一个Thread构造器
* 				调用Thread对象的start()方法为该线程执行必须的初始化操作，然后调用Runnable的run方法，以便在这个新线程中启动该
* 				任务。程序会同时运行两个方法，main()和LiftOff.run()是程序中与其他线程“同时”执行的代码。
 */
public class BasicThreads {
	public static void main(String[] args) {
		Thread t = new Thread(new LiftOff());
		t.start();
		System.out.println("Waiting for LiftOff");
	}
} /*
	 * Output: (90% match) Waiting for LiftOff #0(9), #0(8), #0(7), #0(6), #0(5),
	 * #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
	 */// :~
