package szu.vander.container.foreachanditerator;

//: holding/AdapterMethodIdiom.java
// The "Adapter Method" idiom allows you to use foreach
// with additional kinds of Iterables.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 
* @author      : Vander
* @date        : 2018-11-20
* @description : for([arg1]:[arg2])，arg2需要的是Iterable接口的类，所以只要自定义实现了Iterable接口的
* 				类，就可以在保留原来正常的正向遍历的情况下，添加反向遍历的功能
 */
class ReversibleArrayList<T> extends ArrayList<T> {
	private static final long serialVersionUID = -2149142651780589403L;

	public ReversibleArrayList(Collection<T> c) {
		super(c);
	}

	public Iterable<T> reversed() {
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int current = size() - 1;

					public boolean hasNext() {
						return current > -1;
					}

					public T next() {
						return get(current--);
					}

					public void remove() { // Not implemented
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}

public class AdapterMethodIdiom {
	public static void main(String[] args) {
		ReversibleArrayList<String> ral = new ReversibleArrayList<String>(
				Arrays.asList("To be or not to be".split(" ")));
		// Grabs the ordinary iterator via iterator():
		for (String s : ral)
			System.out.print(s + " ");
		System.out.println();
		// Hand it the Iterable of your choice
		for (String s : ral.reversed())
			System.out.print(s + " ");
	}
} /*
	 * Output: To be or not to be be to not or be To
	 */// :~
