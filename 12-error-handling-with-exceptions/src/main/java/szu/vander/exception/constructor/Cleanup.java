package szu.vander.exception.constructor;

//: exceptions/Cleanup.java
// Guaranteeing proper cleanup of a resource.

/**
 * 
* @author      : Vander
* @date        : 2018-11-21
* @description : 度已于构造阶段可能会抛出的异常，并且要求清理的类，最安全的使用方式是使用嵌套的try字句
 */
public class Cleanup {
	public static void main(String[] args) {
		try {
			InputFile in = new InputFile("src/main/java/szu/vander/exception/constructor/Cleanup.java");
			try {
				String s;
				int i = 1;
				while ((s = in.getLine()) != null) {
					System.out.println(s);
				}
			} catch (Exception e) {
				System.out.println("Caught Exception in main");
				e.printStackTrace(System.out);
			} finally {
				in.dispose();
			}
		} catch (Exception e) {
			System.out.println("InputFile construction failed");
		}
	}
} /*
	 * Output: dispose() successful
	 */// :~
