package szu.vander.generic.erasurecompensate.array;

//: generics/GenericArray.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-12
* @description : 成功创建泛型数组的唯一方式就是创建一个被擦除类型的新数组，然后对其转型
* 				但是这也不可行，因为有了擦除，数组的运行时类型就只能是Object[]。如果我们立即将其转型为T[]，那么在编译器该数组
* 				的实际类型就将丢失，而编译器可能会错过某些潜在的错误检查
 */
public class GenericArray<T> {
	private T[] array;

	public GenericArray(int sz) {
		array = (T[]) new Object[sz];
	}

	public void put(int index, T item) {
		array[index] = item;
	}

	public T get(int index) {
		return array[index];
	}

	// Method that exposes the underlying representation:
	public T[] rep() {
		return array;
	}

	public static void main(String[] args) {
		GenericArray<Integer> gai = new GenericArray<Integer>(10);
		Integer i = gai.get(0);
		// This causes a ClassCastException:
		// ! Integer[] ia = gai.rep();
		// This is OK:
		Object[] oa = gai.rep();
	}
} /// :~
