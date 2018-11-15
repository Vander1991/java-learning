package szu.vander.innerclass.multiinherit.practice.practice22;

// Holds a sequence of Objects.
/**
 * 
* @author      : Vander
* @date        : 2018-11-14
* @description : 
 */			
interface Selector {
	boolean end();

	Object current();

	void next();
}

public class Sequence {
	private Object[] items;
	private int next = 0;

	public Sequence(int size) {
		items = new Object[size];
	}

	public void add(Object x) {
		if (next < items.length)
			items[next++] = x;
	}

	private class SequenceSelector implements Selector {
		private int i = 0;

		public boolean end() {
			return i == items.length;
		}

		public Object current() {
			return items[i];
		}

		public void next() {
			if (i < items.length)
				i++;
		}
	}

	private class ReverseSequenceSelector implements Selector {
		private int i = items.length - 1;

		public boolean end() {
			return i == -1;
		}

		public Object current() {
			return items[i];
		}

		public void next() {
			if (i >= 0)
				i--;
		}
	}
	
	public Selector selector() {
		return new SequenceSelector();
	}

	public Selector reverseSelector() {
		return new ReverseSequenceSelector();
	}
	
	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for (int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		System.out.println("顺序遍历：");
		Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
		System.out.println("");
		System.out.println("逆序遍历：");
		Selector reverseSelector = sequence.reverseSelector();
		while (!reverseSelector.end()) {
			System.out.print(reverseSelector.current() + " ");
			reverseSelector.next();
		}
	}
} /*
	 * Output: 0 1 2 3 4 5 6 7 8 9
	 */// :~
