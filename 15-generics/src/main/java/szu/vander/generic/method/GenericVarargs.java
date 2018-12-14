package szu.vander.generic.method;

//: generics/GenericVarargs.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-11
* @description : 可变参数列表与泛型能很好地共存，makeList和Arrays.asList方法相同的功能
 */
public class GenericVarargs {
	public static <T> List<T> makeList(T... args) {
		List<T> result = new ArrayList<T>();
		for (T item : args) {
			result.add(item);
		}
		return result;
	}

	public static void main(String[] args) {
		List<String> ls = makeList("A");
		System.out.println(ls);
		ls = makeList("A", "B", "C");
		System.out.println(ls);
		ls = makeList("ABCDEFFHIJKLMNOPQRSTUVWXYZ".split(""));
		System.out.println(ls);
	}
} /*
	 * Output: [A] [A, B, C] [, A, B, C, D, E, F, F, H, I, J, K, L, M, N, O, P, Q,
	 * R, S, T, U, V, W, X, Y, Z]
	 */// :~
