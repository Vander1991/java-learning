package szu.vander.generic.simple.stack;

//: generics/LinkedStack.java
// A stack implemented with an internal linked structure.

/**
 * 
* @author      : Vander
* @date        : 2018-12-10
* @description : 内部类Node也是一个泛型，它拥有自己的类型参数
* 				这个例子使用了末端哨兵（end sentinel）来判断堆栈何时为空。这个末端哨兵是在构建LinkedStack时创建的。然后，每
* 				调用一次push()方法，就会创建一个Node<T>对象，并将其链接到前一个Node<T>对象。
 */
public class LinkedStack<T> {
	private static class Node<U> {
		U item;
		Node<U> next;

		Node() {
			item = null;
			next = null;
		}

		Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}

		boolean end() {
			return item == null && next == null;
		}
	}

	private Node<T> top = new Node<T>(); // End sentinel

	public void push(T item) {
		top = new Node<T>(item, top);
	}

	public T pop() {
		T result = top.item;
		if (!top.end()) {
			top = top.next;
		}
		return result;
	}

	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<String>();
		for (String s : "Phasers on stun!".split(" ")) {
			lss.push(s);
		}
		String s;
		while ((s = lss.pop()) != null) {
			System.out.println(s);
		}
	}
} /*
	 * Output: stun! on Phasers
	 */// :~
