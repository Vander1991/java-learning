//: generics/coffee/CoffeeGenerator.java
// Generate different types of Coffee:
package szu.vander.generic.interfaces.coffee;

import java.util.Iterator;
import java.util.Random;

import szu.vander.util.Generator;

/**
 * 
* @author      : Vander
* @date        : 2018-12-10
* @description : CoffeeGenerator同时还实现了Interable接口，所以它可以在循环语句中使用。不过它还需要一个末端哨兵，来判断
* 				何时停止，这个正是第二个构造器的作用。
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
	private Class<?>[] types = { 
			Latte.class, Mocha.class, 
			Cappuccino.class, Americano.class,
			Breve.class, };
	private static Random rand = new Random(47);

	public CoffeeGenerator() {
	}

	// For iteration:
	private int size = 0;

	public CoffeeGenerator(int sz) {
		size = sz;
	}

	public Coffee next() {
		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
			// Report programmer errors at run time:
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	class CoffeeIterator implements Iterator<Coffee> {
		int count = size;

		public boolean hasNext() {
			return count > 0;
		}

		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}

		public void remove() { // Not implemented
			throw new UnsupportedOperationException();
		}
	};

	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
		for (Coffee c : new CoffeeGenerator(5)) {
			System.out.println(c);
		}
	}
} /*
	 * Output: Americano 0 Latte 1 Americano 2 Mocha 3 Mocha 4 Breve 5 Americano 6
	 * Latte 7 Cappuccino 8 Cappuccino 9
	 */// :~
