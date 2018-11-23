package szu.vander.innerclass.anonymous;

//: innerclasses/AnonymousConstructor.java
// Creating a constructor for an anonymous inner class.
import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-14
* @description ：  如果想做一些类似构造器的行为，通过实例初始化，就能够达到匿名内部类创建一个构造器的效果
* 				此例中不要求变量i一定是final，因为i被传递给匿名类的基类的构造器，它并不会在匿名内部类被直接使用
 */
abstract class Base {
	public Base(int i) {
		print("Base constructor, i = " + i);
	}

	public abstract void f();
}

public class AnonymousConstructor {
	public static Base getBase(int i) {
		return new Base(i) {
			// 通过实例初始化来达到相当于构造函数的效果,静态块是不允许的，因为匿名内部类就没有人给他共享一个static
			{
				print("Inside instance initializer");
			}

			public void f() {
				print("In anonymous f()");
			}
		};
	}

	public static void main(String[] args) {
		Base base = getBase(47);
		base.f();
	}
} /*
	 * Output: Base constructor, i = 47 Inside instance initializer In anonymous f()
	 */// :~
