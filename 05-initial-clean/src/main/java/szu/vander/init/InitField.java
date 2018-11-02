package szu.vander.init;
/**
* @author      : Vander
* @date        : 2018-11-01
* @description ： 类中的field保证都有一个初始值
*/
public class InitField {

	private boolean t;
	
	private char c;
	
	private byte b;
	
	private short s;
	
	private int i;
	
	private long l;
	
	private double d;
	
	private InitField initField;
	
	public void printInitValues() {
		System.out.println("Data Type           InitValue");
		System.out.println("boolean             " + t);
		System.out.println("char                " + c);//char初始值是0，所以是空格
		System.out.println("byte                " + b);
		System.out.println("short               " + s);
		System.out.println("int                 " + i);
		System.out.println("long                " + l);
		System.out.println("double              " + d);
		System.out.println("Object              " + initField);
	}
	
	public static void main(String args[]) {
		new InitField().printInitValues();
	}
	
}
