package szu.vander.exception.finallyclean.compare;

//: exceptions/AlwaysFinally.java
// Finally is always executed.
import static szu.vander.util.Printer.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-21
* @description : 在异常没有被当前块的异常捕获程序捕获，finally也会执行，当涉及break和continue语句的时候，
* 				finally子句也会得到执行，如果把finally字句和带标签的break及continue配合使用，在Java里
* 				就没必要使用goto语句了
 */
class FourException extends Exception {
}

public class AlwaysFinally {
	public static void main(String[] args) {
		print("Entering first try block");
		try {
			print("Entering second try block");
			try {
				throw new FourException();
			} finally {
				print("finally in 2nd try block");
			}
		} catch (FourException e) {
			System.out.println("Caught FourException in 1st try block");
		} finally {
			System.out.println("finally in 1st try block");
		}
	}
} /*
	 * Output: Entering first try block Entering second try block finally in 2nd try
	 * block Caught FourException in 1st try block finally in 1st try block
	 */// :~
