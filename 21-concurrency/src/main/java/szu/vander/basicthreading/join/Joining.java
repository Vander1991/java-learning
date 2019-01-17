package szu.vander.basicthreading.join;

//: concurrency/Joining.java
// Understanding join().
import static szu.vander.util.Print.print;

/**
 * 
 * @author : Vander
 * @date : 2019-01-17
 * @description ：如果某个线程在另一个线程t上调用t.join，此线程将被挂起，直到目标线程t结束才恢复
 * 				也可以在join()的时候加上一个超时参数（单位是毫秒），这样如果目标线程在这段时间到期还没结束，join方法总能返回
 * 				对join方法的调用可以被中断，做法是在调用线程上调用interrupt方法。
 */
class Sleeper extends Thread {
	private int duration;

	public Sleeper(String name, int sleepTime) {
		super(name);
		duration = sleepTime;
		start();
	}

	public void run() {
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			print(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
			return;
		}
		print(getName() + " has awakened");
	}
}

class Joiner extends Thread {
	private Sleeper sleeper;

	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}

	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			print("Interrupted");
		}
		print(getName() + " join completed");
	}
}

public class Joining {
	public static void main(String[] args) {
		Sleeper sleepy = new Sleeper("Sleepy", 1500), grumpy = new Sleeper("Grumpy", 1500);
		Joiner dopey = new Joiner("Dopey", sleepy), doc = new Joiner("Doc", grumpy);
		grumpy.interrupt();
	}
} /*
	 * Output: Grumpy was interrupted. isInterrupted(): false Doc join completed
	 * Sleepy has awakened Dopey join completed
	 */// :~
