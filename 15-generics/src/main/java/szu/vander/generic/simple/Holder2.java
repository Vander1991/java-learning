package szu.vander.generic.simple;

//: generics/Holder2.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-10
* @description : 在Jdk1.5之前都是使用Object来实现可重用性
 */
public class Holder2 {
	private Object a;

	public Holder2(Object a) {
		this.a = a;
	}

	public void set(Object a) {
		this.a = a;
	}

	public Object get() {
		return a;
	}

	public static void main(String[] args) {
		Holder2 h2 = new Holder2(new Automobile());
		Automobile a = (Automobile) h2.get();
		h2.set("Not an Automobile");
		String s = (String) h2.get();
		h2.set(1); // Autoboxes to Integer
		Integer x = (Integer) h2.get();
	}
} /// :~
