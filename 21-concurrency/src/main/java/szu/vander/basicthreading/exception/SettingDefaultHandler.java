package szu.vander.basicthreading.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//: concurrency/SettingDefaultHandler.java

/**
 * 
* @author      : Vander
* @date        : 2019-01-17
* @description ： 直接指定所有线程都用同一个异常处理器，并且这个处理器只有在不存在线程专有的未捕获异常处理器的情况下才会被调用
* 				系统会检查线程的专有版本，如果没有发现，则检查线程组是否有其专有的uncaughtException()方法，如果也没有再调用
* 				DefaultUncaughtExceptionHandler
 */
public class SettingDefaultHandler {
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}
} /*
	 * Output: caught java.lang.RuntimeException
	 */// :~
