package szu.vander.exception.catchexception;

//: exceptions/Rethrowing.java
// Demonstrating fillInStackTrace()

/**
* @author      : Vander
* @date        : 2018-11-21
* @description : 使用fillInStackTrace重新填入当前调用信息，调用fillInStackTrace()的那行成了异常的新发生地
* 				说明：
* 					重抛异常会把异常抛给上一级环境中的异常处理程序，同一个try块的后续catch子句将被胡烈。此外，异常对象
* 				的所有信息将得以保存。
 */
public class Rethrowing {
	public static void f() throws Exception {
		System.out.println("originating the exception in f()");
		throw new Exception("thrown from f()");
	}

	public static void g() throws Exception {
		try {
			f();
		} catch (Exception e) {
			System.out.println("Inside g(),e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}

	public static void h() throws Exception {
		try {
			f();
		} catch (Exception e) {
			System.out.println("Inside h(),e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception) e.fillInStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			g();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
		try {
			h();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
	}
} /*
	 * Output: originating the exception in f() Inside g(),e.printStackTrace()
	 * java.lang.Exception: thrown from f() at Rethrowing.f(Rethrowing.java:7) at
	 * Rethrowing.g(Rethrowing.java:11) at Rethrowing.main(Rethrowing.java:29) main:
	 * printStackTrace() java.lang.Exception: thrown from f() at
	 * Rethrowing.f(Rethrowing.java:7) at Rethrowing.g(Rethrowing.java:11) at
	 * Rethrowing.main(Rethrowing.java:29) originating the exception in f() Inside
	 * h(),e.printStackTrace() java.lang.Exception: thrown from f() at
	 * Rethrowing.f(Rethrowing.java:7) at Rethrowing.h(Rethrowing.java:20) at
	 * Rethrowing.main(Rethrowing.java:35) main: printStackTrace()
	 * java.lang.Exception: thrown from f() at Rethrowing.h(Rethrowing.java:24) at
	 * Rethrowing.main(Rethrowing.java:35)
	 */// :~
