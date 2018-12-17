package szu.vander.generic.wildcard.extend;

//: generics/CovariantArrays.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-14
* @description : Fruit[] fruit = new Apple[10]放置的实际是Apple，你只能在其中放置Apple或Apple的子类型
* 				虽然编译器允许你将Fruit放置在这个数组里面，但是运行时数组机制知道它处理的是Apple[]，因此会在向数组中
* 				放置异构类型时抛出异常
* 				 数组可以保留有关它们包含的对象类型的规则，就好像数组对它们持有的对象是有意识的
 */
class Fruit {
}

class Apple extends Fruit {
	
	private final int appleId = counter++; 
	
	private static int counter=0;
	
	public String toString() {
		return "Apple(" + appleId + ")";
	}
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

public class CovariantArrays {
	public static void main(String[] args) {
		Fruit[] fruit = new Apple[10];
		fruit[0] = new Apple(); // OK
		fruit[1] = new Jonathan(); // OK
		// Runtime type is Apple[], not Fruit[] or Orange[]:
		try {
			// Compiler allows you to add Fruit:
			fruit[0] = new Fruit(); // ArrayStoreException
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			// Compiler allows you to add Oranges:
			fruit[0] = new Orange(); // ArrayStoreException
		} catch (Exception e) {
			System.out.println(e);
		}
	}
} /*
	 * Output: java.lang.ArrayStoreException: Fruit java.lang.ArrayStoreException:
	 * Orange
	 */// :~
