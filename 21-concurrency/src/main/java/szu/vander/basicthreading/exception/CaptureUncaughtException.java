package szu.vander.basicthreading.exception;

//: concurrency/CaptureUncaughtException.java
import java.util.concurrent.*;

/**
 * 
* @author      : Vander
* @date        : 2019-01-17
* @description ：Thread.UncaughtExceptionHandler是JDK5的新接口，它允许你在每个Thread对象上附着一个异常处理器。Thread.UncaughtExceptionHandler.uncaughtException()
* 				会在线程因未捕获的异常而临近死忙时被调用
* 				 这个实例为每个线程都创建了相同异常处理器，如果代码中处处用的都是异常处理器，更简单的方式是在Thread类中设置静态域，
* 				并将这个处理器设置为默认的未捕获的异常处理器
 */
class ExceptionThread2 implements Runnable {
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("run() by " + t);
		System.out.println("eh = " + t.getUncaughtExceptionHandler());
		throw new RuntimeException();
	}
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught " + e);
	}
}

class HandlerThreadFactory implements ThreadFactory {
	public Thread newThread(Runnable r) {
		System.out.println(this + " creating new Thread");
		Thread t = new Thread(r);
		System.out.println("created " + t);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("eh = " + t.getUncaughtExceptionHandler());
		return t;
	}
}

public class CaptureUncaughtException {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionThread2());
	}
} /*
	 * Output: (90% match) HandlerThreadFactory@de6ced creating new Thread created
	 * Thread[Thread-0,5,main] eh = MyUncaughtExceptionHandler@1fb8ee3 run() by
	 * Thread[Thread-0,5,main] eh = MyUncaughtExceptionHandler@1fb8ee3 caught
	 * java.lang.RuntimeException
	 */// :~
