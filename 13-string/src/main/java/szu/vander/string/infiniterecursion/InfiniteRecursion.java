package szu.vander.string.infiniterecursion;

//: strings/InfiniteRecursion.java
// Accidental recursion.
// {RunByHand}
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-23
* @description : 这么写会导致递归调用，首先要打印这个对象的时候，会调用toString，然后toString方法中识别到this的时候，又会去调用对象
* 				的toString这样没完没了，如果要打印出内存地址的话，应该用Object.toString方法，这里应该用super.toString()
 */
public class InfiniteRecursion {
	public String toString() {
		//error
		//return " InfiniteRecursion address: " + this + "\n";
		return " InfiniteRecursion address: " + super.toString() + "\n";
	}

	public static void main(String[] args) {
		List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for (int i = 0; i < 10; i++)
			v.add(new InfiniteRecursion());
		System.out.println(v);
	}
}
