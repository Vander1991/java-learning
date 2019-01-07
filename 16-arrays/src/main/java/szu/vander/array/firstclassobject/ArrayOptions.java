package szu.vander.array.firstclassobject;

import static szu.vander.util.Print.print;

//: arrays/ArrayOptions.java
// Initialization & re-assignment of arrays.
import java.util.Arrays;

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-05
 * @description: length表示的是数组能够容纳多少元素，而不是数组确切有多少元素
 * 				对象数组和基本类型数组唯一的区别是对象数组保存的是引用，基本类型数组直接保存基本类型的值。
 */
class BerylliumSphere {

}

public class ArrayOptions {
	public static void main(String[] args) {
		// Arrays of objects:
		BerylliumSphere[] a; // Local uninitialized variable
		BerylliumSphere[] b = new BerylliumSphere[5];
		// The references inside the array are
		// automatically initialized to null:
		print("b: " + Arrays.toString(b));
		BerylliumSphere[] c = new BerylliumSphere[4];
		for (int i = 0; i < c.length; i++) {
			if (c[i] == null) {// Can test for null reference
				c[i] = new BerylliumSphere();
			}
		}
		// Aggregate initialization:
		BerylliumSphere[] d = { new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere() };
		// Dynamic aggregate initialization:
		a = new BerylliumSphere[] { new BerylliumSphere(), new BerylliumSphere(), };
		// (Trailing comma is optional in both cases)
		print("a.length = " + a.length);
		print("b.length = " + b.length);
		print("c.length = " + c.length);
		print("d.length = " + d.length);
		a = d;
		print("a.length = " + a.length);

		// Arrays of primitives:
		int[] e; // Null reference
		int[] f = new int[5];
		// The primitives inside the array are
		// automatically initialized to zero:
		print("f: " + Arrays.toString(f));
		int[] g = new int[4];
		for (int i = 0; i < g.length; i++) {
			g[i] = i * i;
		}
		int[] h = { 11, 47, 93 };
		// Compile error: variable e not initialized:
		// !print("e.length = " + e.length);
		print("f.length = " + f.length);
		print("g.length = " + g.length);
		print("h.length = " + h.length);
		e = h;
		print("e.length = " + e.length);
		e = new int[] { 1, 2 };
		print("e.length = " + e.length);
	}
} /*
	 * Output: b: [null, null, null, null, null] a.length = 2 b.length = 5 c.length
	 * = 4 d.length = 3 a.length = 3 f: [0, 0, 0, 0, 0] f.length = 5 g.length = 4
	 * h.length = 3 e.length = 3 e.length = 2
	 */// :~
