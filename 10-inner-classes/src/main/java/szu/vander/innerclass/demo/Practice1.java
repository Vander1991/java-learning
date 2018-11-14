package szu.vander.innerclass.demo;

/**
* @author      : Vander
* @date        : 2018-11-14
* @description ： 
*/
public class Practice1 {

	public static void main(String args[]) {
		Outer.Inner inner = new Outer().getInner();
	}
	
}

class Outer {
	
	public Inner getInner() {
		return new Inner();
	}
	
	class Inner {
		
	}
}