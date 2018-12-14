package szu.vander.generic.erasedscrect;

//: generics/ArrayMaker.java
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 
* @author      : Vander
* @date        : 2018-12-11
* @description : 即使kind存储为Class<T>，擦除也意味着它实际将存储为Class，没有任何参数。因此，当你使用它时，例如在创建数组时，
* 				Array.newInstance()实际上并每拥有kind所蕴含的类型信息，因此这不会产生具体的结果，所以必须转型，使用
* 				Array.newInstance()是推荐的方式
* 
 */
public class ArrayMaker<T> {
	private Class<T> kind;

	public ArrayMaker(Class<T> kind) {
		this.kind = kind;
	}

	@SuppressWarnings("unchecked")
	T[] create(int size) {
		return (T[]) Array.newInstance(kind, size);
	}

	public static void main(String[] args) {
		ArrayMaker<String> stringMaker = new ArrayMaker<String>(String.class);
		String[] stringArray = stringMaker.create(9);
		System.out.println(Arrays.toString(stringArray));
	}
} /*
	 * Output: [null, null, null, null, null, null, null, null, null]
	 */// :~
