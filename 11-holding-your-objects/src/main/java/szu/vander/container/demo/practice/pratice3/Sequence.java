package szu.vander.container.demo.practice.pratice3;

import java.util.ArrayList;
import java.util.List;

//: innerclasses/Sequence.java
// Holds a sequence of Objects.

interface Selector {
	boolean end();

	Object current();

	void next();
}

public class Sequence {
	private List<String> items;

	public Sequence(int size) {
		items = new ArrayList<String>();
	}

	public void add(String x) {
		items.add(x);
	}

	private class SequenceSelector implements Selector {
		private int i = 0;

		public boolean end() {
			return i == items.size();
		}

		public String current() {
			return items.get(i);
		}

		public void next() {
			if (i < items.size())
				i++;
		}
	}

	public Selector selector() {
		return new SequenceSelector();
	}

	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for (int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
} /*
	 * Output: 0 1 2 3 4 5 6 7 8 9
	 */// :~
