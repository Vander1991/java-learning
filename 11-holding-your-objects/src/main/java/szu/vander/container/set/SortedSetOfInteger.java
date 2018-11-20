package szu.vander.container.set;

//: holding/SortedSetOfInteger.java
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
* @author      : Vander
* @date        : 2018-11-19
* @description : TreeSet将元素存储在红黑树中，而HashSet使用的是散列函数，LinkedHashList因为查询速度的原因也使用了散列，
* 				但是看起来它使用了链表来维护元素的插入顺序
 */
public class SortedSetOfInteger {
	public static void main(String[] args) {
		Random rand = new Random(47);
		SortedSet<Integer> intset = new TreeSet<Integer>();
		for (int i = 0; i < 10000; i++)
			intset.add(rand.nextInt(30));
		System.out.println(intset);
	}
} /*
	 * Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
	 * 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]
	 */// :~
