package szu.vander.basicthreading.daemon;

import static szu.vander.util.Print.*;

//: concurrency/SimpleDaemons.java
// Daemon threads don't prevent the program from ending.
import java.util.concurrent.TimeUnit;

/**
 * 
* @author      : Vander
* @date        : 2019-01-15
* @description ： 所谓后台（Daemon）线程，是指在程序运行的时候在后台提供一种通用服务的线程，并且这种线程并不属于程序中不可或缺
* 				的部分，因此，当所有的非后台线程结束时，程序也就终止了，同时会杀死进程中的所有后台线程，反过来说，只要有任何非
* 				后台线程还在运行，程序就不会终止。比如，执行main()就是一个非后台线程。
* 				 一旦main完成其工作，就没有什么阻止程序终止了，调整main的sleep时间，来观察效果。
 */
public class SimpleDaemons implements Runnable {
	public void run() {
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(100);
				print(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			print("sleep() interrupted");
		}
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true); // Must call before start()
			daemon.start();
		}
		print("All daemons started");
		TimeUnit.MILLISECONDS.sleep(100);
	}
} /*
	 * Output: (Sample) All daemons started Thread[Thread-0,5,main]
	 * SimpleDaemons@530daa Thread[Thread-1,5,main] SimpleDaemons@a62fc3
	 * Thread[Thread-2,5,main] SimpleDaemons@89ae9e Thread[Thread-3,5,main]
	 * SimpleDaemons@1270b73 Thread[Thread-4,5,main] SimpleDaemons@60aeb0
	 * Thread[Thread-5,5,main] SimpleDaemons@16caf43 Thread[Thread-6,5,main]
	 * SimpleDaemons@66848c Thread[Thread-7,5,main] SimpleDaemons@8813f2
	 * Thread[Thread-8,5,main] SimpleDaemons@1d58aae Thread[Thread-9,5,main]
	 * SimpleDaemons@83cc67 ...
	 */// :~
