package szu.vander.array.demo;

import static szu.vander.util.Print.*;

//: arrays/ContainerComparison.java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-04
 * @description: 数组与泛型容器进行比较
 */
class BerylliumSphere {
	private static long counter;
	private final long id = counter++;

	public String toString() {
		return "Sphere " + id;
	}
}

public class ContainerComparison {
	public static void main(String[] args) {
		BerylliumSphere[] spheres = new BerylliumSphere[10];
		for (int i = 0; i < 5; i++) {
			spheres[i] = new BerylliumSphere();
		}
		print(Arrays.toString(spheres));
		print(spheres[4]);

		List<BerylliumSphere> sphereList = new ArrayList<BerylliumSphere>();
		for (int i = 0; i < 5; i++) {
			sphereList.add(new BerylliumSphere());
		}
		print(sphereList);
		print(sphereList.get(4));

		int[] integers = { 0, 1, 2, 3, 4, 5 };
		print(Arrays.toString(integers));
		print(integers[4]);

		List<Integer> intList = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5));
		intList.add(97);
		print(intList);
		print(intList.get(4));
	}
} /*
	 * Output: [Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4, null, null, null,
	 * null, null] Sphere 4 [Sphere 5, Sphere 6, Sphere 7, Sphere 8, Sphere 9]
	 * Sphere 9 [0, 1, 2, 3, 4, 5] 4 [0, 1, 2, 3, 4, 5, 97] 4
	 */// :~
