package szu.vander.generic.selfboundedtype.exercise34;
/**
* @author      : Vander
* @date        : 2018-12-28
* @description ： 创建一个自限定的泛型类型，它包含一个abstract方法，这个方法将接受一个泛型类型参数，并产
* 				生具有这个泛型类型参数的返回值。在这个类的非abstract方法中，调用这个abstract方法，并返回
* 				其结果。继承这个自限定类型，并测试所产生的类。
*/
abstract class Base<T extends Base<T>> {
	public abstract T test(T t);
	public T test2(T t) {
		System.out.println("run test2()");
		System.out.println("test2's t：" + t);
		T result = test(t);
		
		return result;
	}
}

class Derived extends Base<Derived>{

	@Override
	public Derived test(Derived t) {
		System.out.println("run test()");
		System.out.println("test1's t：" + t);
		return t;
	}
	
}

public class Exercise34 {

	public static void main(String args[]) {
		Derived derived = new Derived();
		derived.test2(new Derived());
	}
	
}
