package szu.vander.exception.myexception;

//: exceptions/LoggingExceptions.java
// An exception that reports through a Logger.
import java.util.logging.*;
import java.io.*;

/**
 * 
 * @author : Vander
 * @date : 2018-11-20
 * @description : printStackTrace()不会默认地产生字符创，为了获取字符串，我们需要使用重载的printStackTrace()方法，它接收一个
 * 				 PrintWriter对象作为参数
 */
class LoggingException extends Exception {
	
	private static final long serialVersionUID = -6835125746911432920L;
	
	private static Logger logger = Logger.getLogger("LoggingException");

	public LoggingException() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

public class LoggingExceptions {

	public static void main(String[] args) {
		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught " + e);
		}
	}
} /*
	 * Output: (85% match) Aug 30, 2005 4:02:31 PM LoggingException <init> SEVERE:
	 * LoggingException at LoggingExceptions.main(LoggingExceptions.java:19)
	 * 
	 * Caught LoggingException Aug 30, 2005 4:02:31 PM LoggingException <init>
	 * SEVERE: LoggingException at LoggingExceptions.main(LoggingExceptions.java:24)
	 * 
	 * Caught LoggingException
	 */// :~
