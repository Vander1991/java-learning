package szu.vander.generic.selfboundedtype.selfbound;

//: generics/NotSelfBounded.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-24
* @description : 移除了自限定限制之后E也是可以编译的
 */
public class NotSelfBounded<T> {
	T element;

	NotSelfBounded<T> set(T arg) {
		element = arg;
		return this;
	}

	T get() {
		return element;
	}
}

class A2 extends NotSelfBounded<A2> {
}

class B2 extends NotSelfBounded<A2> {
}

class C2 extends NotSelfBounded<C2> {
	C2 setAndGet(C2 arg) {
		set(arg);
		return get();
	}
}

class D2 {
}

// Now this is OK:
class E2 extends NotSelfBounded<D2> {
} /// :~
