package szu.vander.polymorphism.method;

/**
 * @author : Vander
 * @date : 2018-11-12
 * @description ：
 */
public class StaticMethod {
	public static void main(String[] args) {
		StaticSuper sup = new StaticSub(); // Upcast
		System.out.println(sup.staticGet());
		System.out.println(sup.dynamicGet());
	}
}
