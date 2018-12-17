package szu.vander.generic.wildcard.supers;

//: generics/GenericWriting.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-17
* @description : List<? super T> list 若T为Apple，此时就能将Apple及其子类放入这个list里面，因为它定义了下边界，知道这个
* 				List放置的东西都是Apple的父类，那肯定能放Apple及其子类。但是如果要拿的话，因为编译器只知道里面放置的是Apple的父类
* 				具体是哪个父类无从得知，所以拿出来的话就有问题
* 				 List<? extends T> list，若T为Apple，因为它只知道list里面放置的是Apple的子类，但是具体是什么子类并不知道
* 				编译器也无从得知，所以拒绝往这个list里面放置任何对象，如果是从list里面拿东西出来，它知道里面放置的是Apple的子类，那
* 				将拿出来的对象当成是Apple肯定是可以的。
 */
public class GenericWriting {
	static <T> void writeExact(List<T> list, T item) {
		list.add(item);
	}

	static List<Apple> apples = new ArrayList<Apple>();
	static List<Fruit> fruit = new ArrayList<Fruit>();

	static void f1() {
		writeExact(apples, new Apple());
		// writeExact(fruit, new Apple()); // Error:
		// Incompatible types: found Fruit, required Apple
	}

	static <T> void writeWithWildcard(List<? super T> list, T item) {
		list.add(item);
	}

	static void f2() {
		writeWithWildcard(apples, new Apple());
		writeWithWildcard(fruit, new Apple());
	}

	public static void main(String[] args) {
		f1();
		f2();
	}
}
