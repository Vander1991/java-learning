package szu.vander.generic.selfboundedtype.selfbound;

//: generics/SelfBounding.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-23
* @description : 自限定将采取额外的步骤，强制泛型当做其自己的边界参数来使用 
* 				自限定参数意义：
* 					保证类型参数必须与正在被定义的类相同
* 					还可以从使用了另一个SelfBounded参数的SelfBounded中导出
* 				结合SelfBounding.java可以得出结论：
* 					自限定限制只能强制作用于继承关系。如果使用自限定，就应该使得这个所用的类型参数
* 				与将使用这个参数的类具有相同的基类型
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
// 这里感觉是因为D没做自限定这件事，E就继承它了，这样就不行了
// class E extends SelfBounded<D> {}
// Compile error: Type parameter D is not within its bound

// Alas, you can do this, so you can't force the idiom:
class F extends SelfBounded {
}

public class SelfBounding {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		b.set(a);
		a = b.get();
		a.set(new A());
		a = a.set(new A()).get();
		a = a.get();
		C c = new C();
		c = c.setAndGet(new C());
	}
} /// :~
