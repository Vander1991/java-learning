package szu.vander.exception.myexception;

//: exceptions/FullConstructors.java

/**
 * 
* @author      : Vander
* @date        : 2018-11-20
* @description : 带参数的自定义Exception，如果printStackTrace不指定流，默认输出到System.err
 */
class MyException extends Exception {
	public MyException() {
	}

	public MyException(String msg) {
		super(msg);
	}
}

public class FullConstructors {
	public static void f() throws MyException {
		System.out.println("Throwing MyException from f()");
		throw new MyException();
	}

	public static void g() throws MyException {
		System.out.println("Throwing MyException from g()");
		throw new MyException("Originated in g()");
	}

	public static void main(String[] args) {
		try {
			f();
		} catch (MyException e) {
			e.printStackTrace(System.err);
			e.printStackTrace();
		}
		try {
			g();
		} catch (MyException e) {
			e.printStackTrace(System.out);
		}
	}
} /*
	 * Output: Throwing MyException from f() MyException at
	 * FullConstructors.f(FullConstructors.java:11) at
	 * FullConstructors.main(FullConstructors.java:19) Throwing MyException from g()
	 * MyException: Originated in g() at
	 * FullConstructors.g(FullConstructors.java:15) at
	 * FullConstructors.main(FullConstructors.java:24)
	 */// :~
