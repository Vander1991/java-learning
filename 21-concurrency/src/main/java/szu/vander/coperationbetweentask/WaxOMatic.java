//: concurrency/waxomatic/WaxOMatic.java
// Basic task cooperation.
package szu.vander.coperationbetweentask;

import java.util.concurrent.*;
import static szu.vander.util.Print.*;

/**
 * 
 * @author     : Vander
 * @date       : 2019-02-07
 * @description: 下面有两个线程，一个是抛光，一个是上蜡，首先得先上蜡再抛光然后得再上蜡再抛光，保持这样的执行步骤
 * 				第一个线程先运行起抛光的线程，然后它先调用wait等待上蜡的操作，上蜡操作完了之后通过notifyAll通知
 * 				抛光的线程可以开始抛光了，然后上蜡线程执行wait操作来释放掉它占用的对象锁，让抛光线程能够获得对象锁，
 * 				这样抛光线程才能运行下去。
 */
class Car {
	private boolean waxOn = false;

	// wax-上蜡
	public synchronized void waxed() {
		print("waxing");
		waxOn = true; // Ready to buff
		notifyAll();
	}

	// buffed-抛光
	public synchronized void buffed() {
		print("buffing");
		waxOn = false; // Ready for another coat of wax
		notifyAll();
	}

	public synchronized void waitForWaxing() throws InterruptedException {
		while (waxOn == false) {
			print("waitForWaxing");
			wait();
		}
	}

	public synchronized void waitForBuffing() throws InterruptedException {
		while (waxOn == true) {
			print("waitForBuffing");
			wait();
		}
	}
}

class Wax implements Runnable {
	private Car car;

	public Wax(Car c) {
		car = c;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			print("Exiting via interrupt");
		}
		print("Ending Wax On task");
	}
}

class Buff implements Runnable {
	private Car car;

	public Buff(Car c) {
		car = c;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				car.waitForWaxing();
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch (InterruptedException e) {
			print("Exiting via interrupt");
		}
		print("Ending Wax Off task");
	}
}

public class WaxOMatic {
	public static void main(String[] args) throws Exception {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Buff(car));
		exec.execute(new Wax(car));
		TimeUnit.SECONDS.sleep(1); // Run for a while...
		exec.shutdownNow(); // Interrupt all tasks
	}
} /*
	 * Output:
	 * 	waitForWaxing
	 * 	waxing
	 * 	waitForBuffing
	 * 	buffing
	 * 	waitForWaxing
	 * 	waxing
	 * 	waitForBuffing
	 * 	buffing
	 * 	waitForWaxing
	 * 	Exiting via interrupt
	 * 	Ending Wax Off task
	 * 	Exiting via interrupt
	 * 	Ending Wax On task
	  */
