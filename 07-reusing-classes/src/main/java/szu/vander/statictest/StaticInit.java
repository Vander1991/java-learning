package szu.vander.statictest;

import static szu.vander.util.Printer.*;

/**
 * @author : Vander Choi
 * @date : 2018-11-11
 * @description :
 */
public class StaticInit {

	public static void main(String[] args) {
		print("Beetle constructor");
		Beetle b = new Beetle();
	}
	
}

class Insect {
	private int i = 9;
	protected int j;

	Insect() {
		print("i = " + i + ", j = " + j);
		j = 39;
	}

	private static int x1 = printInit("static Insect.x1 initialized");

	static int printInit(String s) {
		print(s);
		return 47;
	}
}

class Beetle extends Insect {
	private int k = printInit("Beetle.k initialized");

	public Beetle() {
		print("k = " + k);
		print("j = " + j);
	}

	private static int x2 = printInit("static Beetle.x2 initialized");

}
/*
 * Output:
 *  Beetle constructor 
 * 	static Insect.x1 initialized 
 *  static Beetle.x2 initialized 
 *  i = 9, j = 0 
 *  Beetle.k initialized
 *  k = 47 
 *  j = 39
 */
// :~
