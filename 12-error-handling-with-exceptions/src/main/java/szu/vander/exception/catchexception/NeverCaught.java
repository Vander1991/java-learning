package szu.vander.exception.catchexception;

//: exceptions/NeverCaught.java
// Ignoring RuntimeExceptions.
// {ThrowsException}

/**
 * 
* @author      : Vander
* @date        : 2018-11-21
* @description : 如果RuntimeException没有被捕获而直达main()，那么程序退出前将调用异常的printStackTrace()
* 				方法
* 	
 */
public class NeverCaught {
	static void f() {
		throw new RuntimeException("From f()");
	}

	static void g() {
		f();
	}

	public static void main(String[] args) {
		g();
	}
} /// :~
