package szu.vander.generic.question.exercise.exercise33;

import java.util.ArrayList;
import java.util.List;

//: generics/GenericCast.java

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-18
 * @description: 使用ArrayList修复GenericCast.java
 */
class FixedSizeStack<T> {
	private int index = -1;
	private List<T> storage;

	public FixedSizeStack() {
		storage = new ArrayList<T>();
	}

	public void push(T item) {
		storage.add(item);
		index++;
	}

	public T pop() {
		T item = storage.get(index);
		storage.remove(index);
		index--;
		return item;
	}
	
	public boolean hasNext() {
		return !storage.isEmpty();
	}
	
}

public class MyGenericCast {

	public static void main(String[] args) {
		FixedSizeStack<String> strings = new FixedSizeStack<String>();
		for (String s : "A B C D E F G H I J K L M N".split(" ")) {
			strings.push(s);
		}
		String s = null;
		while(strings.hasNext()) {
			s = strings.pop();
			System.out.println(s);
		}
	}
} /*
	 * Output: J I H G F E D C B A
	 */// :~
