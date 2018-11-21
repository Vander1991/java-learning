package szu.vander.exception.myexception;

//: exceptions/InheritingExceptions.java
// Creating your own exceptions.

/**
 * 
* @author      : Vander
* @date        : 2018-11-20
* @description : 自定义异常
* 				要自己定义异常类，必须从已有的异常类继承，最好是选择意思相近的异常类继承（不过并不好找）
* 				建立新的异常类型最简单的方法是让编译器为你产生默认构造器。
 */
class SimpleException extends Exception {
}

public class InheritingExceptions {
	public void f() throws SimpleException {
		System.out.println("Throw SimpleException from f()");
		throw new SimpleException();
	}

	public static void main(String[] args) {
		InheritingExceptions sed = new InheritingExceptions();
		try {
			sed.f();
		} catch (SimpleException e) {
			System.out.println("Caught it!");
		}
	}
} /*
	 * Output: Throw SimpleException from f() Caught it!
	 */// :~
