package szu.vander.generic.method;

//: generics/GenericMethods.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-11
* @description : 要想使用泛型方法，只需要将泛型参数放在返回值之前
* 				我们可以像调用普通方法那样调用f()，就像f()被重载了无数次一样，它甚至可以接收GenericMethods作为其类型参数
 */
public class GenericMethods {
	public <T> void f(T x) {
		System.out.println(x.getClass().getName());
	}

	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		gm.f("");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0F);
		gm.f('c');
		gm.f(gm);
	}
} /*
	 * Output: java.lang.String java.lang.Integer java.lang.Double java.lang.Float
	 * java.lang.Character GenericMethods
	 */// :~
