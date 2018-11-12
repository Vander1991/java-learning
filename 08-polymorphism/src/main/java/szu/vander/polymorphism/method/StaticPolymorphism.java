package szu.vander.polymorphism.method;

/**
 * 
 * @author : Vander
 * @date : 2018-11-12
 * @description ： 静态方法不具有多态性
 */
class StaticSuper {
	public static String staticGet() {
		return "Base staticGet()";
	}

	public String dynamicGet() {
		return "Base dynamicGet()";
	}
}

class StaticSub extends StaticSuper {
	public static String staticGet() {
		return "Derived staticGet()";
	}

	public String dynamicGet() {
    return "Derived dynamicGet()";
  }
}
