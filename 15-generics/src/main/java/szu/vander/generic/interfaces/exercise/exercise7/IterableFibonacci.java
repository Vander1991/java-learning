package szu.vander.generic.interfaces.exercise.exercise7;

//: generics/IterableFibonacci.java
// Adapt the Fibonacci class to make it Iterable.
import java.util.*;

import szu.vander.generic.interfaces.fibonacci.Fibonacci;

/**
 * 
* @author      : Vander
* @date        : 2018-12-10
* @description : 使用适配器模式来实现Iterator迭代器
 */
public class IterableFibonacci implements Iterable<Integer> {
	
	private Fibonacci fibonacci = new Fibonacci();
	
	private int n;

	public IterableFibonacci(int count) {
		n = count;
	}

	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			public boolean hasNext() {
				return n > 0;
			}

			public Integer next() {
				n--;
				return fibonacci.next();
			}

			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}


}

