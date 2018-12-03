//: generics/coffee/CoffeeGenerator.java
// Generate different types of Coffee:
package szu.vander.typeinfo.registeredfactory.exercise.exercise16.coffee;

import java.util.Iterator;

import szu.vander.util.Generator;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

	public CoffeeGenerator() {
	}

	private int size = 0;

	public CoffeeGenerator(int sz) {
		size = sz;
	}

	public Coffee next() {
		return Coffee.createRandom();
	}

	class CoffeeIterator implements Iterator<Coffee> {
		int count = size;

		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}

		public void remove() { // Not implemented
			throw new UnsupportedOperationException();
		}
		
	}

	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

}

