package szu.vander.generic.selfboundedtype;

//: generics/SelfBounding.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-23
* @description : 自限定参数意义：
* 					保证类型参数必须与正在被定义的类相同
* 					还可以从使用了另一个SelfBounded参数的SelfBounded中导出
* 				自限定限制只能强制作用于继承关系。如果使用自限定，就应该了解这个所用的类型参数与将使用这个参数的类
* 				具有相同的基类型
 */
class SelfBounded<T extends SelfBounded<T>> {
	T element;

	SelfBounded<T> set(T arg) {
		element = arg;
		return this;
	}

	T get() {
		return element;
	}
}

class A extends SelfBounded<A> {
}

class B extends SelfBounded<A> {
} // Also OK

class C extends SelfBounded<C> {
	C setAndGet(C arg) {
		set(arg);
		return get();
	}
}

class D {
}
// Can't do this:
// class E extends SelfBounded<D> {}
// Compile error: Type parameter D is not within its bound

// Alas, you can do this, so you can't force the idiom:
class F extends SelfBounded {
}

public class SelfBounding {
	public static void main(String[] args) {
		A a = new A();
		a.set(new A());
		a = a.set(new A()).get();
		a = a.get();
		C c = new C();
		c = c.setAndGet(new C());
	}
} /// :~
