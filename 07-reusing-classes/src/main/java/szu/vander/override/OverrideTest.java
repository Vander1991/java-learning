package szu.vander.override;
/**
* @author      : Vander
* @date        : 2018-11-09
* @description ： 
*/
public class OverrideTest {

	public static void main(String args[]) {
		SubPrinter printer = new SubPrinter();
		printer.print(1.0f);
		printer.print('a');
	}
	
}

class Printer {
	
	void print(String str) {
		System.out.println(str);
	}
	
	void print(int i) {
		System.out.println(i);
	}
	
	void print(float f) {
		System.out.println(f);
	}
	
}

class SubPrinter extends Printer {
	
	void print(char c) {
		System.out.println(c);
	}
	
	// 告诉你这个方法是重写的，此注解用于防止你在不想重载时而意外地进行了重载
	@Override
	void print(float f) {
		System.out.println(f+1);
	}
	
}