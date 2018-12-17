package szu.vander.generic.question;

//: generics/ListOfInt.java
// Autoboxing compensates for the inability to use
// primitives in generics.
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-17
* @description : 任何基本类型不能作为类型参数，但是可以利用基本类型的包装器类以及JDK5的自动包装机制,就好像定义了基本类型的泛型类一样
 */
public class ListOfInt {
	public static void main(String[] args) {
		List<Integer> li = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			li.add(i);
		}
		for (int i : li) {
			System.out.print(i + " ");
		}
	}
} /*
	 * Output: 0 1 2 3 4
	 */// :~
