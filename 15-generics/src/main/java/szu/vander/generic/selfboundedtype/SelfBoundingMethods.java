package szu.vander.generic.selfboundedtype;

//: generics/SelfBoundingMethods.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-24
* @description : 还可以将自限定类型用于方法
 */
public class SelfBoundingMethods {
	static <T extends SelfBounded<T>> T f(T arg) {
		return arg.set(arg).get();
	}

	public static void main(String[] args) {
		A a = f(new A());
	}
} /// :~
