package szu.vander.generic.erasedscrect;

//: generics/ErasedTypeEquivalence.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-11
* @description : 尽管可以声明ArrayList.class但是不能声明ArrayList<Integer>.class
* 				残酷的现实是：在泛型代码内部，无法获得任何有关泛型参数类型的信息
 */
public class ErasedTypeEquivalence {
	public static void main(String[] args) {
		Class c1 = new ArrayList<String>().getClass();
		Class c2 = new ArrayList<Integer>().getClass();
		System.out.println(c1 == c2);
	}
} /*
	 * Output: true
	 */// :~
