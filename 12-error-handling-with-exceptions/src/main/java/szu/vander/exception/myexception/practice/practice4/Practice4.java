package szu.vander.exception.myexception.practice.practice4;
/**
* @author      : Vander
* @date        : 2018-11-20
* @description ： 
*/
class MyException extends Exception {
	
	public MyException(String desc) {
		super(desc);
	}
	
}

public class Practice4 {
	
	public static void main(String args[]) {
		try {
			throw new MyException("MyException1");
		} catch(MyException e) {
			e.printStackTrace();
		} finally {
			System.out.println("end the main");
		}
	}
	
}
