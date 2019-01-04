package szu.vander.generic.functionobjectsasstrategy.exercise42;

import static szu.vander.util.Print.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author     : Vander
* @date       : 2019-01-03
* @description: 创建一个类持有一个值，并至少有产生这个值和在这个值上执行修改的方法。
* 				修改Functional.java，使它可以在由你的类构成的集合上执行函数型操作
*/

class A implements Comparable<A>{
	
	private int a;
	
	public A(int a) {
		this.a = a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	public int getA() {
		return a;
	}

	@Override
	public int compareTo(A objectA) {
		if(objectA.getA() > a) {
			return 0;
		}
		return a;
	}
	
	public String toString() {
		return a + "";
	}
	
}

interface UnaryPredicate<T> {
	boolean test(T x);
}

public class Exercise42 {

	static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
		private T bound;

		public GreaterThan(T bound) {
			this.bound = bound;
		}

		public boolean test(T x) {
			return x.compareTo(bound) > 0;
		}
	}
	
	public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
		List<T> result = new ArrayList<T>();
		for (T t : seq) {
			if (pred.test(t)) {
				result.add(t);
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		List<A> numList = Arrays.asList(new A(1), new A(3), new A(5), new A(6));
		print(filter(numList, new GreaterThan<A>(new A(4))));
	}
	
}
