package szu.vander.typeinfo.interfaceandtypeinfo;

//: typeinfo/InnerImplementation.java
// Private inner classes can't hide from reflection.
import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-09
* @description : 使用反射一样能访问私有内部类
 */
class InnerA {
	private static class C implements A {
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

	public static A makeA() {
		return new C();
	}
}

public class InnerImplementation {
	public static void main(String[] args) throws Exception {
		A a = InnerA.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		// Reflection still gets into the private class:
		HiddenImplementation.callHiddenMethod(a, "g");
		HiddenImplementation.callHiddenMethod(a, "u");
		HiddenImplementation.callHiddenMethod(a, "v");
		HiddenImplementation.callHiddenMethod(a, "w");
	}
} /*
	 * Output: public C.f() InnerA$C public C.g() package C.u() protected C.v()
	 * private C.w()
	 */// :~
