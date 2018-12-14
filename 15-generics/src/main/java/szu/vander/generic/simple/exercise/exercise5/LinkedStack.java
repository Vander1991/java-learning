package szu.vander.generic.simple.exercise.exercise5;

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
	private class Node {
		T item;
		Node next;

		Node() {
			item = null;
			next = null;
		}

		Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}

		boolean end() {
			return item == null && next == null;
		}
	}

	private Node top = new Node(); // End sentinel

	public void push(T item) {
		top = new Node(item, top);
	}

	public T pop() {
		T result = top.item;
		if (!top.end()) {
			top = top.next;
		}
		return result;
	}

} /*
	 * Output: stun! on Phasers
	 */// :~
