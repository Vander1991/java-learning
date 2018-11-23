package szu.vander.exception.myexception;

//: exceptions/ExtraFeatures.java
// Further embellishment of exception classes.
import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-20
* @description : 异常也是一种对象，所以可以修改异常类，以得到更强的功能，但是一般客户端程序员可能仅仅查看一下抛出的异常类型，其他的不管了，
* 				所以添加了其他功能可能根本用不上
 */
class MyException2 extends Exception {
	private int x;

	public MyException2() {
	}

	public MyException2(String msg) {
		super(msg);
	}

	public MyException2(String msg, int x) {
		super(msg);
		this.x = x;
	}

	public int val() {
		return x;
	}

	public String getMessage() {
		return "Detail Message: " + x + " " + super.getMessage();
	}
}

public class ExtraFeatures {
	public static void f() throws MyException2 {
		print("Throwing MyException2 from f()");
		throw new MyException2();
	}

	public static void g() throws MyException2 {
		print("Throwing MyException2 from g()");
		throw new MyException2("Originated in g()");
	}

	public static void h() throws MyException2 {
		print("Throwing MyException2 from h()");
		throw new MyException2("Originated in h()", 47);
	}

	public static void main(String[] args) {
		try {
			f();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
		}
		try {
			g();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
		}
		try {
			h();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
			System.out.println("e.val() = " + e.val());
		}
	}
} /*
	 * Output: Throwing MyException2 from f() MyException2: Detail Message: 0 null
	 * at ExtraFeatures.f(ExtraFeatures.java:22) at
	 * ExtraFeatures.main(ExtraFeatures.java:34) Throwing MyException2 from g()
	 * MyException2: Detail Message: 0 Originated in g() at
	 * ExtraFeatures.g(ExtraFeatures.java:26) at
	 * ExtraFeatures.main(ExtraFeatures.java:39) Throwing MyException2 from h()
	 * MyException2: Detail Message: 47 Originated in h() at
	 * ExtraFeatures.h(ExtraFeatures.java:30) at
	 * ExtraFeatures.main(ExtraFeatures.java:44) e.val() = 47
	 */// :~
