package szu.vander.exception.discussion.practice.practice28;
/**
* @author      : Vander
* @date        : 2018-11-20
* @description ： 
*/
class MyException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MyException(String desc) {
		super(desc);
	}
	
}

public class Practice28 {
	
	public static void main(String args[]) {
		throw new MyException("MyException1");
	}
	
}
