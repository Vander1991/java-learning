package szu.vander.container.map;

//: holding/Statistics.java
// Simple demonstration of HashMap.
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-19
* @description : 将对象映射到其他对象的能力是一种解决编程问题的杀手锏
* 				以下程序是用来检查Java的Random类的随机性，理想状态下，Random可以产生理想的数字分布，要测试它，需要产生大量随机数
* 				并对落入各种不同范围的数字进行计数
 */
public class Statistics {
	public static void main(String[] args) {
		Random rand = new Random(47);
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10000; i++) {
			// Produce a number between 0 and 20:
			int r = rand.nextInt(20);
			Integer freq = m.get(r);
			m.put(r, freq == null ? 1 : freq + 1);
		}
		System.out.println(m);
	}
} /*
	 * Output: {15=497, 4=481, 19=464, 8=468, 11=531, 16=533, 18=478, 3=508, 7=471,
	 * 12=521, 17=509, 2=489, 13=506, 9=549, 6=519, 1=502, 14=477, 10=513, 5=503,
	 * 0=481}
	 */// :~
