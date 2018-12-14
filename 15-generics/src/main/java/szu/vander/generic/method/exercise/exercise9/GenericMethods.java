package szu.vander.generic.method.exercise.exercise9;

//: generics/GenericMethods.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-11
* @description : 修改GenericMethods使其能接收三个参数
 */
public class GenericMethods {
	public <K, V, R> void f(K k, V v, R r) {
		System.out.println(k.getClass().getName());
		System.out.println(v.getClass().getName());
		System.out.println(r.getClass().getName());
	}

	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		gm.f("", 1, gm);
	}
}
