package szu.vander.exception.catchexception;

//: exceptions/RethrowNew.java
// Rethrow a different object from the one that was caught.

/**
 * 
* @author      : Vander
* @date        : 2018-11-21
* @description : 捕获异常后抛出另一种异常，得到的效果类似于使用fillInStackTrace()，有关原来异常发生点的信息会丢失
* 				剩下的是与新的抛出点有关的信息
 */
class OneException extends Exception {
	public OneException(String s) {
		super(s);
	}
}

class TwoException extends Exception {
	public TwoException(String s) {
		super(s);
	}
}

public class RethrowNew {
	public static void f() throws OneException {
		System.out.println("originating the exception in f()");
		throw new OneException("thrown from f()");
	}

	public static void main(String[] args) {
		try {
			try {
				f();
			} catch (OneException e) {
				System.out.println("Caught in inner try, e.printStackTrace()");
				e.printStackTrace(System.out);
				throw new TwoException("from inner try");
			}
		} catch (TwoException e) {
			System.out.println("Caught in outer try, e.printStackTrace()");
			e.printStackTrace(System.out);
		}
	}
} /*
	 * Output: originating the exception in f() Caught in inner try,
	 * e.printStackTrace() OneException: thrown from f() at
	 * RethrowNew.f(RethrowNew.java:15) at RethrowNew.main(RethrowNew.java:20)
	 * Caught in outer try, e.printStackTrace() TwoException: from inner try at
	 * RethrowNew.main(RethrowNew.java:25)
	 */// :~
