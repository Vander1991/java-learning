package szu.vander.generic.method.exercise.exercise10;

//: generics/GenericMethods.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-11
* @description : 修改GenericMethods使其其中一个参数修改为非参数化的类型
 */
public class GenericMethods {
	public <K, V, R> void f(K k, V v, GenericMethods gm) {
		System.out.println(k.getClass().getName());
		System.out.println(v.getClass().getName());
		System.out.println(gm);
	}

	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		gm.f("", 1, gm);
	}
}
