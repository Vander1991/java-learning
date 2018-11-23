package szu.vander.innerclass.local;

//: innerclasses/LocalInnerClass.java
// Holds a sequence of Objects.
import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-16
* @description : 在代码块中创建的内部类就是----局部内部类
* 				局部内部类不能有访问说明符。因为它不是外围类的一部分；但它可以额访问当前代码块内的常量以及外围类的
* 				所有成员
* 				下面的例子用了局部内部类和匿名内部类完成
* 				使用局部内部类不用匿名内部类：
* 					1、需要一个已命名的构造器，或者需要重载构造器（匿名内部类只能用于实例化）
* 					2、需要不止一个该内部类的对象
 */
interface Counter {
	int next();
}

public class LocalInnerClass {
	private int count = 0;

	Counter getCounter(final String name) {
		// A local inner class:
		class LocalCounter implements Counter {
			public LocalCounter() {
				// Local inner class can have a constructor
				print("LocalCounter()");
			}

			public int next() {
				print(name); // Access local final
				return count++;
			}
		}
		return new LocalCounter();
	}

	// The same thing with an anonymous inner class:
	Counter getCounter2(final String name) {
		return new Counter() {
			// Anonymous inner class cannot have a named
			// constructor, only an instance initializer:
			{
				print("Counter()");
			}

			public int next() {
				print(name); // Access local final
				return count++;
			}
		};
	}

	public static void main(String[] args) {
		LocalInnerClass lic = new LocalInnerClass();
		Counter c1 = lic.getCounter("Local inner "), 
				c2 = lic.getCounter2("Anonymous inner ");
		for (int i = 0; i < 5; i++)
			print(c1.next());
		for (int i = 0; i < 5; i++)
			print(c2.next());
	}
} /*
	 * Output: LocalCounter() Counter() Local inner 0 Local inner 1 Local inner 2
	 * Local inner 3 Local inner 4 Anonymous inner 5 Anonymous inner 6 Anonymous
	 * inner 7 Anonymous inner 8 Anonymous inner 9
	 */// :~
