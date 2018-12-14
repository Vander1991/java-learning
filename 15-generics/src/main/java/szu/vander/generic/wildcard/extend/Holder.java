package szu.vander.generic.wildcard.extend;

//: generics/Holder.java

public class Holder<T> {
	private T value;

	public Holder() {
	}

	public Holder(T val) {
		value = val;
	}

	public void set(T val) {
		value = val;
	}

	public T get() {
		return value;
	}

	public boolean equals(Object obj) {
		return value.equals(obj);
	}

	public static void main(String[] args) {
		Holder<Apple> appleHolder = new Holder<Apple>(new Apple());
		Apple apple = appleHolder.get();
		appleHolder.set(apple);
		// Holder<Fruit> Fruit = Apple; // Cannot upcast
		Holder<? extends Fruit> fruitHolder = appleHolder; // OK
		Fruit f = fruitHolder.get();
		apple = (Apple) fruitHolder.get(); // Returns 'Object'
		//fruitHolder.set(new Fruit());
		//set()方法不能工作于Apple或Fruit，因为set()的参数也是"? extends Fruit"，编译器无法验证“不确定事物”的
		//类型安全性
		try {
			Orange c = (Orange) fruitHolder.get(); // No warning
		} catch (Exception e) {
			System.out.println(e);
		}
		// fruit.set(new Apple()); // Cannot call set()
		// fruit.set(new Fruit()); // Cannot call set()
		System.out.println(fruitHolder.equals(apple)); // OK
	}
} /*
	 * Output: (Sample) java.lang.ClassCastException: Apple cannot be cast to Orange
	 * true
	 */// :~
