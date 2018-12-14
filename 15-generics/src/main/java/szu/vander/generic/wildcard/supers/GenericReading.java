package szu.vander.generic.wildcard.supers;

//: generics/GenericReading.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-14
* @description : ConvariantReader.readCovcariant()方法将接受List<? extends T>，因此，从这个列表中读取
* 				一个T是安全的（你知道这个列表中的所有对象至少是一个T，并且可能是从T导出的某种对象）
 */
public class GenericReading {
	static <T> T readExact(List<T> list) {
		return list.get(0);
	}

	static List<Apple> apples = Arrays.asList(new Apple());
	static List<Fruit> fruits = Arrays.asList(new Fruit());
	
	// f4()没有错误得用下面的方式创建List
//	static List<Apple> apples = new ArrayList<Apple>();
//	static List<Fruit> fruits = new ArrayList<Fruit>();

	// A static method adapts to each call:
	static void f1() {
		Apple a = readExact(apples);
		Fruit f = readExact(fruits);
		f = readExact(apples);
	}

	// If, however, you have a class, then its type is
	// established when the class is instantiated:
	static class Reader<T> {
		T readExact(List<T> list) {
			return list.get(0);
		}
	}

	static void f2() {
		Reader<Fruit> fruitReader = new Reader<Fruit>();
		Fruit f = fruitReader.readExact(fruits);
		// Fruit a = fruitReader.readExact(apples); // Error:
		// readExact(List<Fruit>) cannot be
		// applied to (List<Apple>).
	}

	static class CovariantReader<T> {
		T readCovariant(List<? extends T> list) {
			return list.get(0);
		}
	}

	static <T> void writeContravariant(List<? super T> list, T item) {
		list.add(item);
	}
	
	static void f3() {
		CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
		Fruit f = fruitReader.readCovariant(fruits);
		Fruit a = fruitReader.readCovariant(apples);
	}
	
	static void f4() {
		writeContravariant(apples, new Apple());
	}
	
	public static void main(String[] args) {
		f1();
		f2();
		f3();
	}
} /// :~
