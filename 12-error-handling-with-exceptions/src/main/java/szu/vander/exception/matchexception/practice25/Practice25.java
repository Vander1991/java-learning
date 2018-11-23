package szu.vander.exception.matchexception.practice25;
/**
* @author      : Vander
* @date        : 2018-11-22
* @description ： 
*/
class BaseException extends Exception {
	private static final long serialVersionUID = 1L;
}

class FurtherException1 extends BaseException {
	private static final long serialVersionUID = 2L;
}

class FurtherException2 extends FurtherException1 {
	private static final long serialVersionUID = 2L;
}

class A {
	public void testA() throws BaseException {
		throw new BaseException();
	}
}

class B extends A {
	public void testA() throws FurtherException1 {
		throw new FurtherException1();
	}
}

class C extends B {
	public void testA() throws FurtherException2 {
		throw new FurtherException2();
	}
}

public class Practice25 {

	public static void main(String args[])  {
		A c = new C();
		try {
			c.testA();
		} catch (BaseException e) {
			e.printStackTrace();
		}
	}
	
}
