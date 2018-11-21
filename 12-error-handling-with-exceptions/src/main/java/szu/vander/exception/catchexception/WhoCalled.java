package szu.vander.exception.catchexception;

//: exceptions/WhoCalled.java
// Programmatic access to stack trace information.

/**
 * 
* @author      : Vander
* @date        : 2018-11-21
* @description : printStackTrace()方法提供的信息可以通过getStackTrace方法来直接访问，这个方法返回一个由栈轨迹
* 				总的元素构成的数组，其中每个元素表示栈中的一帧。元素0是栈顶元素，并且是调用序列中的最后一个方法调用
* 				（Throwable被创建和抛出之处）
 */
public class WhoCalled {
	static void f() {
		// Generate an exception to fill in the stack trace
		try {
			throw new Exception();
		} catch (Exception e) {
			for (StackTraceElement ste : e.getStackTrace())
				System.out.println(ste.getMethodName());
		}
	}

	static void g() {
		f();
	}

	static void h() {
		g();
	}

	public static void main(String[] args) {
		f();
		System.out.println("--------------------------------");
		g();
		System.out.println("--------------------------------");
		h();
	}
} /*
	 * Output: f main -------------------------------- f g main
	 * -------------------------------- f g h main
	 */// :~
