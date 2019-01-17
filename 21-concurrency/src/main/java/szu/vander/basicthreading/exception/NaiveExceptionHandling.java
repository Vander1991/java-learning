package szu.vander.basicthreading.exception;

//: concurrency/NaiveExceptionHandling.java
// {ThrowsException}
import java.util.concurrent.*;

/**
 * 
* @author      : Vander
* @date        : 2019-01-17
* @description ：在Main中捕获不到该异常
 */
public class NaiveExceptionHandling {
	public static void main(String[] args) {
		try {
			ExecutorService exec = Executors.newCachedThreadPool();
			exec.execute(new ExceptionThread());
		} catch (RuntimeException ue) {
			// This statement will NOT execute!
			System.out.println("Exception has been handled!");
		}
	}
} /// :~
