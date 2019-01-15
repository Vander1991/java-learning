package szu.vander.basicthreading.yield;

/**
 * 
* @author      : Vander
* @date        : 2019-01-15
* @description ：实现Runnable本身并没有特殊之处——不会产生任何内在的线程能力，要实现线程行为，需要将一个任务附着到线程上
 */
public class LiftOff implements Runnable {
	protected int countDown = 10; // Default
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
	}

	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
			// 告诉调度器，现在已经处理完最重要的部分了，现在是机会去调度别的线程了。
			Thread.yield();
		}
	}
} /// :~
