package szu.vander.typeinfo.interfaceandtypeinfo;

//: typeinfo/InterfaceViolation.java
// Sneaking around an interface.

/**
 * 
* @author      : Vander
* @date        : 2018-12-09
* @description : 通过使用RTTI（运行时类型转换），将A转型为B，还是可以调用不在A中的B的方法
 */
class B implements A {
	public void f() {
	}

	public void g() {
	}
}

public class InterfaceViolation {
	public static void main(String[] args) {
		A a = new B();
		a.f();
		// a.g(); // Compile error
		System.out.println(a.getClass().getName());
		if (a instanceof B) {
			B b = (B) a;
			b.g();
		}
	}
}
