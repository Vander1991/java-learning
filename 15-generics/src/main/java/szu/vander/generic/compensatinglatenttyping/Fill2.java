package szu.vander.generic.compensatinglatenttyping;

import static szu.vander.util.Print.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import szu.vander.generic.interfaces.coffee.Coffee;
import szu.vander.generic.interfaces.coffee.Latte;
import szu.vander.generic.interfaces.coffee.Mocha;
import szu.vander.util.Generator;
import szu.vander.util.SimpleQueue;

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-02
 * @description: Fill2对Collection的要求与Fill不同，它需要实现Addable的对象
 * 				使用像这样的适配器看起来是对缺乏潜在类型机制的一种补偿，因此允许编写出真正的泛化代码。
 * 				潜在类型机制通过移除这个额外的步骤，使得泛化代码更容易应用。
 */
interface Addable<T> {
	void add(T t);
}

public class Fill2 {
	// Classtoken version:
	public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
		for (int i = 0; i < size; i++)
			try {
				addable.add(classToken.newInstance());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}

	// Generator version:
	public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
		for (int i = 0; i < size; i++) {
			addable.add(generator.next());
		}
	}
}

// To adapt a base type, you must use composition.
// Make any Collection Addable using composition:
class AddableCollectionAdapter<T> implements Addable<T> {
	private Collection<T> c;

	public AddableCollectionAdapter(Collection<T> c) {
		this.c = c;
	}

	public void add(T item) {
		c.add(item);
	}
}

// A Helper to capture the type automatically:
class Adapter {
	public static <T> Addable<T> collectionAdapter(Collection<T> c) {
		return new AddableCollectionAdapter<T>(c);
	}
}

// To adapt a specific type, you can use inheritance.
// Make a SimpleQueue Addable using inheritance:
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
	public void add(T item) {
		super.add(item);
	}
}

class Fill2Test {
	public static void main(String[] args) {
		// Adapt a Collection:
		List<Coffee> carrier = new ArrayList<Coffee>();
		Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier), Coffee.class, 3);
		// Helper method captures the type:
		Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class, 2);
		for (Coffee c : carrier) {
			print(c);
		}
		print("----------------------");
		// Use an adapted class:
		AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<Coffee>();
		Fill2.fill(coffeeQueue, Mocha.class, 4);
		Fill2.fill(coffeeQueue, Latte.class, 1);
		for (Coffee c : coffeeQueue) {
			print(c);
		}
	}
} /*
	 * Output: Coffee 0 Coffee 1 Coffee 2 Latte 3 Latte 4 ----------------------
	 * Mocha 5 Mocha 6 Mocha 7 Mocha 8 Latte 9
	 */// :~
