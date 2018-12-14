package szu.vander.generic.erasurecompensate.array;

//: generics/GenericArrayWithTypeToken.java
import java.lang.reflect.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-13
* @description : 传递一个类型标记就可以创建T[]了
 */
public class GenericArrayWithTypeToken<T> {
	private T[] array;

	@SuppressWarnings("unchecked")
	public GenericArrayWithTypeToken(Class<T> type, int sz) {
		array = (T[]) Array.newInstance(type, sz);
	}

	public void put(int index, T item) {
		array[index] = item;
	}

	public T get(int index) {
		return array[index];
	}

	// Expose the underlying representation:
	public T[] rep() {
		return array;
	}

	public static void main(String[] args) {
		GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<Integer>(Integer.class, 10);
		// This now works:
		Integer[] ia = gai.rep();
	}
} /// :~
