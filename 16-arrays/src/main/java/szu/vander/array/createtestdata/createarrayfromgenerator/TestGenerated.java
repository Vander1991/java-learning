package szu.vander.array.createtestdata.createarrayfromgenerator;

import java.util.Arrays;
import java.util.List;

import szu.vander.array.createtestdata.generator.CountingGenerator;

public class TestGenerated {
	public static void main(String[] args) {
		Integer[] a = { 9, 8, 7, 6 };
		System.out.println(Arrays.toString(a));
		a = Generated.array(a, new CountingGenerator.Integer());
		System.out.println(Arrays.toString(a));
		Integer[] b = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
		System.out.println(Arrays.toString(b));
		
		// 测试toArray方法中传入的参数与返回的值的区别
		String [] c = new String[10];
		List<String> arrayList = Arrays.asList("1", "2");
		String[] d = arrayList.toArray(c);
		System.out.println("c == d? result=" + (c == d));
		
	}
} /*
	 * Output: [9, 8, 7, 6] [0, 1, 2, 3] [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
	 * 13, 14]
	 */// :~
