package szu.vander.array.Multidimensionalarray;

//: arrays/RaggedArray.java
import java.util.*;

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-05
 * @description: 第一个new创建了数组，其第一维的长度是由随机数确定的，其他维的长度则没有定义。
 */
public class RaggedArray {
	public static void main(String[] args) {
		Random rand = new Random(47);
		// 3-D array with varied-length vectors:
		int[][][] a = new int[rand.nextInt(7)][][];
		for (int i = 0; i < a.length; i++) {
			a[i] = new int[rand.nextInt(5)][];
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = new int[rand.nextInt(5)];
			}
		}
		System.out.println(Arrays.deepToString(a));
	}
} /*
	 * Output: [[], [[0], [0], [0, 0, 0, 0]], [[], [0, 0], [0, 0]], [[0, 0, 0], [0],
	 * [0, 0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0], []], [[0], [], [0]]]
	 */// :~
