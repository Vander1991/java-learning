package szu.vander.array.arrayandgeneric;

//: arrays/ArrayOfGenerics.java
// It is possible to create arrays of generics.
import java.util.ArrayList;
import java.util.List;

import szu.vander.array.BerylliumSphere;

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-05
 * @description: 数组是协变类型，因此List<String>[]也是一个Object[]，并且你可以利用这一点，将一个ArrayList<Integer>赋值到你的数组中，
 * 				而不会得到任何编译器或运行期的错误。
 * 				
 */
public class ArrayOfGenerics {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<String>[] ls;
		List[] la = new List[10];
		ls = (List<String>[]) la; // "Unchecked" warning
		ls[0] = new ArrayList<String>();
		// Compile-time checking produces an error:
		// ! ls[1] = new ArrayList<Integer>();

		// The problem: List<String> is a subtype of Object
		Object[] objects = ls; // So assignment is OK
		// Compiles and runs without complaint:
		objects[1] = new ArrayList<Integer>();

		// However, if your needs are straightforward it is
		// possible to create an array of generics, albeit
		// with an "unchecked" warning:
		List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[]) new List[10];
		for (int i = 0; i < spheres.length; i++) {
			spheres[i] = new ArrayList<BerylliumSphere>();
		}
	}
} /// :~
