package szu.vander.container.foreachanditerator;

//: holding/ForEachCollections.java
// All collections work with foreach.
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 
* @author      : Vander
* @date        : 2018-11-20
* @description : 之所以能这么遍历，是因为Jdk1.5引入了新的被称为Iterable的接口，该接口包含一个能够产生Iterator的
* 				Iterator()方法，并且Iterable接口呗foreach用来在序列中移动
 */
public class ForEachCollections {
	public static void main(String[] args) {
		Collection<String> cs = new LinkedList<String>();
		Collections.addAll(cs, "Take the long way home".split(" "));
		for (String s : cs)
			System.out.print("'" + s + "' ");
	}
} /*
	 * Output: 'Take' 'the' 'long' 'way' 'home'
	 */// :~
