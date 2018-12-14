package szu.vander.generic.erasedscrect.exercise20;

/**
 * @author : Vander
 * @date : 2018-12-11
 * @description ： 创建一个具有两个方法的接口，以及一个实现了这个接口并添加了另一个方法的类。在另一个类中，创建一个泛型方法，它的参数类型
 *              由这个接口定义边界，并展示该接口中的方法在这个泛型方法中都是可调用的。在main()方法中传递一个实现类的实体给这泛型方法
 */
interface Interface {
	void method1();

	void method2();
}

class Sample1 implements Interface {

	@Override
	public void method1() {
		System.out.println("Sample1:method1()");
	}

	@Override
	public void method2() {
		System.out.println("Sample1:method2()");
	}
	
	public void method3() {
		
	}
	
}

class Sample2 {
	public static <T extends Interface> void method4(T t) {
		t.method1();
		t.method2();
	}
}

public class Exercise20 {
	public static void main(String args[]) {
		Sample2.method4(new Sample1());
	}
}
