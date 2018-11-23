package szu.vander.exception.discussion;

import static szu.vander.util.Print.*;

//: exceptions/TurnOffChecking.java
// "Turning off" Checked exceptions.
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
* @author      : Vander
* @date        : 2018-11-23
* @description : 把“被检查的异常”转换为“不检查的异常”，有两种方式：
* 				1、将异常在main中throws掉，把它传递到控制台，这种方式不常用
* 				2、将异常转换为RuntimeException，这样不会把异常丢失，，让它自己沿着调用栈往上冒泡，用getCause()捕获并处理特定的异常
 */
class WrapCheckedException {
	
	void throwRuntimeException(int type) {
		try {
			switch (type) {
			case 0:
				throw new FileNotFoundException();
			case 1:
				throw new IOException();
			case 2:
				throw new RuntimeException("Where am I?");
			default:
				return;
			}
		} catch (Exception e) { // Adapt to unchecked:
			throw new RuntimeException(e);
		}
	}
}

class SomeOtherException extends Exception {
	private static final long serialVersionUID = 4355325786887861183L;
}

public class TurnOffChecking {
	public static void main(String[] args) {
		WrapCheckedException wce = new WrapCheckedException();
		// You can call throwRuntimeException() without a try
		// block, and let RuntimeExceptions leave the method:
		wce.throwRuntimeException(3);
		// Or you can choose to catch exceptions:
		for (int i = 0; i < 4; i++)
			try {
				if (i < 3)
					wce.throwRuntimeException(i);
				else
					throw new SomeOtherException();
			} catch (SomeOtherException e) {
				print("SomeOtherException: " + e);
			} catch (RuntimeException re) {
				try {
					throw re.getCause();
				} catch (FileNotFoundException e) {
					print("FileNotFoundException: " + e);
				} catch (IOException e) {
					print("IOException: " + e);
				} catch (Throwable e) {
					print("Throwable: " + e);
				}
			}
	}
} /*
	 * Output: FileNotFoundException: java.io.FileNotFoundException IOException:
	 * java.io.IOException Throwable: java.lang.RuntimeException: Where am I?
	 * SomeOtherException: SomeOtherException
	 */// :~
