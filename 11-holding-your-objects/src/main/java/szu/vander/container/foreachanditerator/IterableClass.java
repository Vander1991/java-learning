package szu.vander.container.foreachanditerator;

//: holding/IterableClass.java
// Anything Iterable works with foreach.
import java.util.Iterator;

/**
 * 
* @author      : Vander
* @date        : 2018-11-20
* @description : 实现Iterable接口，就可以使用ForEach语句来进行遍历操作
* 				在jdk1.5中，所有的Collection类都是Iterable类型（不包括Map）
 */
public class IterableClass implements Iterable<String> {
	protected String[] words = ("And that is how we know the Earth to be banana-shaped.").split(" ");

	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index = 0;

			public boolean hasNext() {
				return index < words.length;
			}

			public String next() {
				return words[index++];
			}

			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		for (String s : new IterableClass())
			System.out.print(s + " ");
	}
} /*
	 * Output: And that is how we know the Earth to be banana-shaped.
	 */// :~
