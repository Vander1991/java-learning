package szu.vander.exception.constraint;

//: exceptions/StormyInning.java
// Overridden methods may throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions.

/**
 * 
* @author      : Vander
* @date        : 2018-11-21
* @description : 当覆盖方法时，只能抛出在基类方法的异常说明里列出的那些异常。这个限制很有用，因为这意味着，当基类使用的
* 				代码应用到其派生类对象的时候，一样能够工作
* 				 说白了就是基类使用的异常，子类也能用
* 					接口Storm包含一个在Inning中的event和不在Inning中的rainHard()，StromyInning类在
* 				扩展Inning类的同时又实现了Storm接口，那么Storm里的event()就不能改变在Inning中的event()方法
* 				的异常接口，否则，在使用基类的时候就不能判断是否捕获了正确的异常。也就是说继承抽象类和实现接口的类，不能指定
* 				这个方法所抛出的异常，唯一的方法就是不写抛出哪个异常。
* 					异常限制对构造器不起作用，StormyInning类的构造器可以抛出任何异常，不必理会父类抛出的异常
* 					walk方法表示父类方法没有抛出异常，子类覆盖方法也不能抛出异常。因为原来是父类的对象调用walk的时候，
* 				不需要catch异常，但是到了父类引用子类对象的时候，不catch异常就会出错了。所以通过强制派生类遵守基类方法
* 				的异常说明，对象的可替换性得到了保证。
* 					最后值得注意的是main()，如果处理的刚好是StromyInning对象的话，编译器只会强制要求你捕获这个类
* 				所抛出的异常。如果它upcast成基类，编译器会要求你捕获基类的异常
* 					总结：如果父类方法抛了异常，子类可以不抛，相当于异常相比继承限制是放大而不是变小
 */					
class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {
	public Inning() throws BaseballException {
	}

	// 强制用户去捕获可能在覆盖后的event()版本中增加的异常
	public void event() throws BaseballException {
		// Doesn't actually have to throw anything
	}

	public abstract void atBat() throws Strike, Foul;

	public void walk() {
	} // Throws no checked exceptions
}

class StormException extends Exception {
}

class RainedOut extends StormException {
}

class PopFoul extends Foul {
	// foul - 犯规
}

interface Storm {
	public void event() throws RainedOut;

	public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
	// OK to add new exceptions for constructors, but you
	// must deal with the base constructor exceptions:
	public StormyInning() throws RainedOut, BaseballException {
	}

	public StormyInning(String s) throws Foul, BaseballException {
	}

	// Regular methods must conform to base class:
	// ! void walk() throws PopFoul {} //Compile error
	// Interface CANNOT add exceptions to existing
	// methods from the base class:
	// ! public void event() throws RainedOut {}
	// If the method doesn't already exist in the
	// base class, the exception is OK:
	public void rainHard() throws RainedOut {
	}

	// You can choose to not throw any exceptions,
	// even if the base version does:
	public void event() {
	}

	// Overridden methods can throw inherited exceptions:
	public void atBat() throws PopFoul {
	}

	public static void main(String[] args) {
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		} catch (PopFoul e) {
			System.out.println("Pop foul");
		} catch (RainedOut e) {
			System.out.println("Rained out");
		} catch (BaseballException e) {
			System.out.println("Generic baseball exception");
		}
		// Strike not thrown in derived version.
		try {
			// What happens if you upcast?
			Inning i = new StormyInning();
			i.atBat();
			// You must catch the exceptions from the
			// base-class version of the method:
		} catch (Strike e) {
			System.out.println("Strike");
		} catch (Foul e) {
			System.out.println("Foul");
		} catch (RainedOut e) {
			System.out.println("Rained out");
		} catch (BaseballException e) {
			System.out.println("Generic baseball exception");
		}
	}
} /// :~
