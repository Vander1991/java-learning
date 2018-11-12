package szu.vander.abstractclass;

/**
 * @author : Vander
 * @date : 2018-11-12
 * @description ：可以创建一个没有任何方法的抽象类，并且其子类也能实例化。
 */
public class AbstractTest {

	public static void main() {
		System.out.println("main()");
	}
	
	public static void main(String args[]) {
		new A();
		main();
	}

}

abstract class AbstractA {

}

class A extends AbstractA {

}