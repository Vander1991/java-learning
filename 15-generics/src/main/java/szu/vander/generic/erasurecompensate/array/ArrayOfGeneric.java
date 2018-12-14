package szu.vander.generic.erasurecompensate.array;

//: generics/ArrayOfGeneric.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-12
* @description : 问题在于数组将跟踪他们的实际类型，而这个类型是在数组被创建时确定的，因此，即使gia已经被转型为Generic<Integer>[]，
* 				但是这个信息只存在于编译器。运行时，它仍旧是Object数组，这将引发问题。
 */
public class ArrayOfGeneric {
	static final int SIZE = 100;
	static Generic<Integer>[] gia;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Compiles; produces ClassCastException:
		// ! gia = (Generic<Integer>[])new Object[SIZE];
		// Runtime type is the raw (erased) type:
		gia = (Generic<Integer>[]) new Generic[SIZE];
		System.out.println(gia.getClass().getSimpleName());
		gia[0] = new Generic<Integer>();
		// ! gia[1] = new Object(); // Compile-time error
		// Discovers type mismatch at compile time:
		// ! gia[2] = new Generic<Double>();
	}
} /*
	 * Output: Generic[]
	 */// :~
