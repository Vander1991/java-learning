package szu.vander.generic.method.exercise.exercise13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import szu.vander.generic.interfaces.coffee.Coffee;
import szu.vander.generic.interfaces.coffee.CoffeeGenerator;
import szu.vander.generic.interfaces.fibonacci.Fibonacci;
import szu.vander.util.Generator;

/**
 * 
 * @author : Vander
 * @date : 2018-12-11
 * @description :
 *              重载fill方法，使其参数与返回值的类型为Collection的导出类：List、Queue和Set，通过这种方式，我们就不会丢失
 *              容器的类型。能够在重载时区分List和LinkedList吗？
 */
public class Generators {
	public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
		for (int i = 0; i < n; i++)
			coll.add(gen.next());
		return coll;
	}

	public static <T> Collection<T> fill(List<T> coll, Generator<T> gen, int n) {
		System.out.println("I am List!");
		for (int i = 0; i < n; i++)
			coll.add(gen.next());
		return coll;
	}

	public static <T> Collection<T> fill(LinkedList<T> coll, Generator<T> gen, int n) {
		System.out.println("I am LinkedList!");
		for (int i = 0; i < n; i++)
			coll.add(gen.next());
		return coll;
	}

	public static <T> Queue<T> fill(Queue<T> coll, Generator<T> gen, int n) {
		for (int i = 0; i < n; i++)
			coll.add(gen.next());
		return coll;
	}

	public static void main(String[] args) {
		Collection<Coffee> coffee = fill(new LinkedList<Coffee>(), new CoffeeGenerator(), 4);
		for (Coffee c : coffee) {
			System.out.println(c);
		}

		Collection<Integer> ints = fill(new ArrayList<Integer>(), new Fibonacci(), 4);
		for (Integer i : ints) {
			System.out.println(i);
		}

		// You need explicit casting from LinkedList to Queue because LinkedList
		// implements both List and Queue interfaces;
		List<Integer> intList = (List<Integer>) fill(new LinkedList<Integer>(), new Fibonacci(), 12);
		for (int i : intList) {
			System.out.print(i + " ");
		}
		Queue<Integer> iQueue = (Queue<Integer>) fill(new LinkedList<Integer>(), new Fibonacci(), 12);
		for (int i : iQueue) {
			System.out.print(i + " ");
		}

	}
} /*
	 * Output: Americano 0 Latte 1 Americano 2 Mocha 3 1, 1, 2, 3, 5, 8, 13, 21, 34,
	 * 55, 89, 144,
	 */// :~
