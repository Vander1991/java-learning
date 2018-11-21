package szu.vander.exception.myexception.practice.practice6;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
* @author      : Vander
* @date        : 2018-11-20
* @description ： 
*/
class MyException1 extends Exception {
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger("MyException1");
	
	public MyException1() {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printStackTrace(printWriter);
		logger.warning(stringWriter.toString());
	}
	
}

class MyException2 extends Exception {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger("MyException2");
	
	public MyException2() {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printStackTrace(printWriter);
		logger.warning(stringWriter.toString());
	}
}

public class Practice6 {

	public static void main(String args[]) {
		try {
			throw new MyException1();
		} catch (MyException1 e) {
			e.printStackTrace();
		}
		
		try {
			throw new MyException2();
		} catch (MyException2 e) {
			e.printStackTrace();
		}
		
	}
	
	
}
