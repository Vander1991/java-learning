package szu.vander.terminatetask;
//: concurrency/Interrupting.java
// Interrupting a blocked thread.
import static szu.vander.util.Print.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
* @author      : Vander
* @date        : 2019-02-06
* @description : Sleep而阻塞的线程是可以中断的，但是由于IO、Synchronized阻塞的线程是不能中断的
 */
class SleepBlocked implements Runnable {
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			print("InterruptedException");
		}
		print("Exiting SleepBlocked.run()");
	}
}

class IOBlocked implements Runnable {
	private InputStream in;

	public IOBlocked(InputStream is) {
		in = is;
	}

	public void run() {
		try {
			print("Waiting for read():");
			in.read();
		} catch (IOException e) {
			if (Thread.currentThread().isInterrupted()) {
				print("Interrupted from blocked I/O");
			} else {
				throw new RuntimeException(e);
			}
		}
		print("Exiting IOBlocked.run()");
	}
}

class SynchronizedBlocked implements Runnable {
	public synchronized void f() {
		while (true) // Never releases lock
			Thread.yield();
	}

	// 一new这个对象出来，这个线程就获得了f()方法的锁，其他线程想调用f()只能被阻塞了
	public SynchronizedBlocked() {
		new Thread() {
			public void run() {
				f(); // Lock acquired by this thread
			}
		}.start();
	}

	public void run() {
		print("Trying to call f()");
		f();
		print("Exiting SynchronizedBlocked.run()");
	}
}

public class Interrupting {
	private static ExecutorService exec = Executors.newCachedThreadPool();

	static void test(Runnable r) throws InterruptedException {
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		print("Interrupting " + r.getClass().getName());
		f.cancel(true); // Interrupts if running
		print("Interrupt sent to " + r.getClass().getName());
	}

	public static void main(String[] args) throws Exception {
		test(new SleepBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		print("Aborting with System.exit(0)");
		System.exit(0); // ... since last 2 interrupts failed
	}
} /*
	 * Output: (95% match) 
	 * Interrupting SleepBlocked 
	 * InterruptedException Exiting
	 * SleepBlocked.run() 
	 * Interrupt sent to SleepBlocked 
	 * Waiting for read():
	 * Interrupting IOBlocked
	 * Interrupt sent to IOBlocked
	 * Trying to call f()
	 * Interrupting SynchronizedBlocked
	 * Interrupt sent to SynchronizedBlocked
	 * Aborting with System.exit(0)
	 */// :~
