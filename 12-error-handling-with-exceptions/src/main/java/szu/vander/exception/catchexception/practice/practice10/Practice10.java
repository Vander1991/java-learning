package szu.vander.exception.catchexception.practice.practice10;
/**
* @author      : Vander
* @date        : 2018-11-21
* @description ： 
*/
class MyException1 extends Exception {
	public MyException1() {
		super("MyException1");
	}
}

class MyException2 extends Exception {
	public MyException2() {
		super("MyException2");
	}
}

class Test {
	void f() throws MyException2 {
		try {
			g();
		} catch (MyException1 e) {
			e.printStackTrace();
			throw new MyException2();
		}
	}
	void g() throws MyException1 {
		throw new MyException1();
	}
}

public class Practice10 {

	public static void main(String args[]) {
		try {
			new Test().f();
		} catch (MyException2 e) {
			e.printStackTrace();
		}
	}
	
}
