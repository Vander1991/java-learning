//: typeinfo/packageaccess/HiddenC.java
package szu.vander.typeinfo.interfaceandtypeinfo;

import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-09
* @description : 虽然w、v方法的权限是包访问权限和私有权限，但是通过反射可以调用他们
 */
class C implements A {
	public void f() {
		print("public C.f()");
	}

	public void g() {
		print("public C.g()");
	}

	void u() {
		print("package C.u()");
	}

	protected void v() {
		print("protected C.v()");
	}

	private void w() {
		print("private C.w()");
	}
}

public class HiddenC {
	public static A makeA() {
		return new C();
	}
}
