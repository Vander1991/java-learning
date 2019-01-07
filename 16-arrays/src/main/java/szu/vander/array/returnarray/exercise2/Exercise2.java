package szu.vander.array.returnarray.exercise2;

import java.util.Arrays;

/**
* @author     : Vander
* @date       : 2019-01-05
* @description: 编写一个方法，它接受一个int参数，并返回一个具有该尺寸的数组，用BerylliumSphere对象填充该数组
*/
class BerylliumSphere {
	
	private static int counter = 1;
	
	private final int id = counter++;
	
	public String toString() {
		return "BerylliumSphere[" + id + "]";
	}
	
}

public class Exercise2 {

	static BerylliumSphere[] fill(int length) {
		BerylliumSphere[] berylliumSpheres= new BerylliumSphere[length];
		for(int i=0; i<length; i++) {
			berylliumSpheres[i] = new BerylliumSphere();
		}
		return berylliumSpheres;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(fill(5)));
	}

}
