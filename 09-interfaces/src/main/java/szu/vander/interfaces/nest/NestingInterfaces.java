package szu.vander.interfaces.nest;

import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-13
* @description ：
* 				1、 a.getD()本来应该返回A.D但是由于D是private所以无法访问，并且如果想返回A.DImpl2，
* 				但是a.getD()方法返回的是D,只有一种方式是可行的，就是将返回值交给有权使用它的对象（receiveD()）
* 				2、嵌套在接口中的接口只能是public
 */
class A {
	interface B {
		void f();
	}

	public class BImp implements B {
		public void f() {
			print("BImp.f()");
		}
	}

	private class BImp2 implements B {
		public void f() {
			print("BImp2.f()");
		}
	}

	public interface C {
		void f();
	}

	class CImp implements C {
		public void f() {
			print("CImp.f()");
		}
	}

	private class CImp2 implements C {
		public void f() {
			print("CImp2.f()");
		}
	}

	private interface D {
		void f();
	}

	private class DImp implements D {
		public void f() {
			print("DImp.f()");
		}
	}

	public class DImp2 implements D {
		public void f() {
			print("DImp2.f()");
		}
	}

	public D getD() {
		return new DImp2();
	}

	private D dRef;

	public void receiveD(D d) {
		dRef = d;
		dRef.f();
	}
}

interface E {
	interface G {
		void f();
	}

	// Redundant-多余 "public":
	public interface H {
		void f();
	}

	void g();
	// Cannot be private within an interface:
	// ! private interface I {}
}

public class NestingInterfaces {
	public class BImp implements A.B {
		public void f() {
			print("impl A.B----BImp.f()");
		}
	}

	class CImp implements A.C {
		public void f() {
			print("impl A.C----CImp.f()");
		}
	}

	// Cannot implement a private interface except
	// within that interface's defining class:
	// ! class DImp implements A.D {
	// ! public void f() {}
	// ! }
	class EImp implements E {
		public void g() {
			print("impl E----EImp.g()");
		}
	}

	class EGImp implements E.G {
		public void f() {
			print("impl E.G----EGImp.f()");
		}
	}

	class EImp2 implements E {
		public void g() {
			print("impl E----EImp2.g()");
		}

		class EG implements E.G {
			public void f() {
				print("impl E.G----EG.f()");
			}
		}
	}

	public static void main(String[] args) {
		A a = new A();
		// Can't access A.D:
		// ! A.D ad = a.getD();
		// Doesn't return anything but A.D:
		// ! A.DImp2 di2 = a.getD();
		// Cannot access a member of the interface:
		// ! a.getD().f();
		// Only another A can do anything with getD():
		A a2 = new A();
		a2.receiveD(a.getD());
	}
} /// :~
