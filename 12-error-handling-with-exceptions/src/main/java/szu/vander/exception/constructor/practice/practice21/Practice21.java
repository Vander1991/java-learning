package szu.vander.exception.constructor.practice.practice21;
/**
* @author      : Vander
* @date        : 2018-11-21
* @description ：   
*/
class MyException1 extends Exception {
	public MyException1() {
		super("MyException1");
	}
	public MyException1(String desc) {
		super(desc);
	}
}

class MyException2 extends MyException1 {
	public MyException2() {
		super("MyException2");
	}
}

class Father {
	public Father() throws MyException1 {
		
	}
	void g() throws MyException1 {
		throw new MyException1();
	}
}

class Son extends Father {
	public Son() throws MyException1 {
		
	}
	void g() {
	}
}

public class Practice21 {

	public static void main(String args[]) {
		try {
			new Son().g();
		} catch (MyException1 e) {
			e.printStackTrace();
		}
	}
	
}
