//: net/mindview/util/Stack.java
// Making a stack from a LinkedList.
package szu.vander.container.stack;

import java.util.LinkedList;

/**
 * 
* @author      : Vander
* @date        : 2018-11-19
* @description : 使用LinkedList实现栈
* 				这里使用组合来实现栈的功能，如果使用继承LinkedList就不合适了，因为这样会产生具有LinkedList
* 				的其他所有方法的类
 */
public class Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();

	public void push(T v) {
		storage.addFirst(v);
	}

	public T peek() {
		return storage.getFirst();
	}

	public T pop() {
		return storage.removeFirst();
	}

	public boolean empty() {
		return storage.isEmpty();
	}

	public String toString() {
		return storage.toString();
	}
} /// :~
