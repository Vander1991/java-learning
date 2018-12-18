package szu.vander.generic.question.exercise.exercise32;

//: generics/GenericCast.java

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-18
 * @description: 验证在GenericCast.java中的FixedSizeStack将产生异常，如果试图超出其边界的话，是否意味着边界检查代码不需要？
 */
class FixedSizeStack<T> {
	private int index = 0;
	private Object[] storage;

	public FixedSizeStack(int size) {
		storage = new Object[size];
	}

	public void push(T item) {
		storage[index++] = item;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		return (T) storage[--index];
	}
}

public class GenericCast {
	public static final int SIZE = 10;

	public static void main(String[] args) {
		FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);
		for (String s : "A B C D E F G H I J K L M N".split(" ")) {
			strings.push(s);
		}
		for (int i = 0; i < SIZE; i++) {
			String s = strings.pop();
			System.out.print(s + " ");
		}
	}
} /*
	 * Output: J I H G F E D C B A
	 */// :~
