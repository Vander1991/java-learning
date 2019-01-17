package szu.vander.basicthreading.daemon;

import static szu.vander.util.Print.*;

//: concurrency/DaemonsDontRunFinally.java
// Daemon threads don't run the finally clause
import java.util.concurrent.TimeUnit;

/**
 * 
* @author      : Vander
* @date        : 2019-01-17
* @description ：后台进程在不执行finally子句的情况下就会终止run()方法
 */
class ADaemon implements Runnable {
	public void run() {
		try {
			print("Starting ADaemon");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			print("Exiting via InterruptedException");
		} finally {
			print("This should always run?");
		}
	}
}

public class DaemonsDontRunFinally {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	}
} /*
	 * Output: Starting ADaemon
	 */// :~
