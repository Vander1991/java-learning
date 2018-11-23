package szu.vander.init;

import static szu.vander.util.Print.print;

/**
* @author      : Vander
* @date        : 2018-11-01
* @description ： 
*/
public class NonStaticInit {

	public static void main(String args[]) {
		print("Inside main");
		new Mugs();
		print("new Mugs() Complete");
		new Mugs(1);
		print("new Mugs(1) Complete");
	}
}

class Mug{
	public Mug(int marker) {
		print("Mug(" + marker + ")");
	}
}

class Mugs{
	Mug mup1 = new Mug(1);
	Mug mup2;
	{
		mup2 = new Mug(2);
		mup1 = new Mug(3);
	}
	public Mugs() {
		print("Mugs()");
	}
	public Mugs(int marker) {
		print("Mugs("+ marker +")");
	}
}