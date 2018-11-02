package szu.vander.init;

import static szu.vander.util.Printer.*;

/**
* @author      : Vander
* @date        : 2018-11-01
* @description ： 
*/
public class ExplicitStatic {

	public static void main(String args[]) {
		print("Inside main");
		Cups.cup1.f(99);
	}
	static Cups cups1 = new Cups();
}

class Cup{
	public Cup(int marker) {
		print("Cup(" + marker + ")");
	}
	
	public void f(int marker) {
		print("f(" + marker + ")");
	}
}

class Cups{
	static Cup cup1 = new Cup(1);
	static Cup cup2;
	static {
		cup2 = new Cup(2);
		cup1 = new Cup(3);
	}
	public Cups() {
		print("Cups()");
	}
}