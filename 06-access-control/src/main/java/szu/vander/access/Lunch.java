package szu.vander.access;

import static szu.vander.util.Print.print;


/**
* @author      : Vander
* @date        : 2018-11-02
* @description ：  单例模式
*/
public class Lunch {

	public static void main(String args[]) {
		Soup1 soup1 = Soup1.makeSoup();
		Soup2.makeSoup().f();
		print(soup1);
	}
	
}

class Soup1 {
	
	private Soup1() {}
	
	public static Soup1 makeSoup() {
		return new Soup1();
	}
	
}


class Soup2 {
	
	private static Soup2 soup2 = new Soup2();
	
	private Soup2() {}
	
	public static Soup2 makeSoup() {
		return soup2;
	}
	
	public void f() {
		print("f()");
	}
	
}
