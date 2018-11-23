package szu.vander.baseclass;

import static szu.vander.util.Print.*;
/**
* @author      : Vander
* @date        : 2018-11-09
* @description ： 在构造器中调用基类构造器来执行初始化，而基类构造器具有执行基类初始化所需的所有知识和能力
*/
public class BaseConstructor {

	public static void main(String args[]) {
		new C();
	}
	
}

class A {
	A() {
		print("A()");
	}
}

class B {
	B() {
		System.out.println("B()");
	}
}

class C extends A {
	B b;
}


