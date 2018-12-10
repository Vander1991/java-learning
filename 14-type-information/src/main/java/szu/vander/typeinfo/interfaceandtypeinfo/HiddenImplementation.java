package szu.vander.typeinfo.interfaceandtypeinfo;

//: typeinfo/HiddenImplementation.java
// Sneaking around package access.

import java.lang.reflect.Method;

/**
 * 
* @author      : Vander
* @date        : 2018-12-09
* @description : 使用反射就能访问private和protected的方法
 */
public class HiddenImplementation {
	public static void main(String[] args) throws Exception {
		A a = HiddenC.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		// Compile error: cannot find symbol 'C':
		/*
		 * if(a instanceof C) { C c = (C)a; c.g(); }
		 */
		// Oops! Reflection still allows us to call g():
		callHiddenMethod(a, "g");
		// And even methods that are less accessible!
		callHiddenMethod(a, "u");
		callHiddenMethod(a, "v");
		callHiddenMethod(a, "w");
	}

	static void callHiddenMethod(Object a, String methodName) throws Exception {
		Method g = a.getClass().getDeclaredMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}
} /*
	 * Output: 
	 * 		public C.f()
	 * 		szu.vander.typeinfo.interfaceandtypeinfo.C
	 * 		public C.g()
	 * 		package C.u()
	 * 		protected C.v() 
	 * 		private C.w()
	 */// :~
