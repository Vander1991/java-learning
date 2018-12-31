package szu.vander.generic.selfboundedtype.selfbound;

//: generics/Unconstrained.java

class BasicHolder<T> {
	T element;

	void set(T arg) {
		element = arg;
	}

	T get() {
		return element;
	}

	void f() {
		System.out.println(element.getClass().getSimpleName());
	}
} 

class Other {
}

class BasicOther extends BasicHolder<Other> {
}

public class Unconstrained {
	public static void main(String[] args) {
		BasicOther b = new BasicOther(), 
				b2 = new BasicOther();
		b.set(new Other());
		Other other = b.get();
		b.f();
	}
} /*
	 * Output: Other
	 */// :~
