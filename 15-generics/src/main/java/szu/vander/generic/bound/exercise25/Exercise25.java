package szu.vander.generic.bound.exercise25;
/**
* @author      : Vander
* @date        : 2018-12-14
* @description ：  创建两个接口和一个实现了这两个接口的类。创建两个泛型方法，其中一个参数边界被限定为第一个接口，而另一个参数
* 				边界被限定为第二个接口。创建实现了这两个接口的类的实例，并展示它可以用于这两个泛型方法
*/
interface interfaceA {
	
}

interface interfaceB {
	
}

class ClassA implements interfaceA, interfaceB {
	static <T extends interfaceA> void testA(T t){
		System.out.println("testA:" + t.getClass().getSimpleName());
	}
	
	static <T extends interfaceB> void testB(T t){
		System.out.println("testB:" + t.getClass().getSimpleName());
	}
}

public class Exercise25 {

	public static void main(String args[]) {
		ClassA classA = new ClassA();
		ClassA.testA(classA);
		ClassA.testB(classA);
	}
	
}
