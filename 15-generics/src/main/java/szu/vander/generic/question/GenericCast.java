package szu.vander.generic.question;

//: generics/GenericCast.java

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-18
 * @description: 编译器会对pop()产生"unchecked cast"警告。由于擦除的原因，编译器无法知道这个转型是否是安全的，并且pop()方法实际上并没有执行转型，
 * 				这是因为，T被擦除到了它的第一个边界，默认情况下是Object，因此pop()实际上只是将Object转成Object
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
		for (String s : "A B C D E F G H I J".split(" ")) {
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
