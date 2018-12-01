//: typeinfo/toys/ToyTest.java
// Testing class Class.
package szu.vander.typeinfo.classloader;

import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-30
* @description : 无论何时，只要你想在运行时使用类型信息，就必须首先获得对恰当的Class对象的引用。Class.forName()就是
* 				实现此功能的便捷途径，因为你不需要为了获得Class引用而持有该类型的对象。通过调用getClass()方法来获取Class
* 				引用，这个方法属于Object的一部分，它将返回表示该对象的实际类型的Class引用
* 				getCanonicalName()与getClassName()效果一样？都是产生全限定的类名
* 					Class的newInstance()方法是实现“虚拟构造器”的一种途径，虚拟构造器允许你声明：“我不知道你的确切类型，
* 				但是无论如何要正确地创建你自己。” 另外使用new Instance()创建的类，必须带有默认的构造器。
 */
interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
	// Comment out the following default constructor
	// to see NoSuchMethodError from (*1*)
	Toy() {
	}

	Toy(int i) {
	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	FancyToy() {
		super(1);
	}
}

public class ToyTest {
	static void printInfo(Class cc) {
		print("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
		print("Simple name: " + cc.getSimpleName());
		print("Canonical name : " + cc.getCanonicalName());
	}

	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("szu.vander.typeinfo.classloader.FancyToy");
		} catch (ClassNotFoundException e) {
			print("Can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);
		for (Class face : c.getInterfaces()) {
			printInfo(face);
		}
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			// Requires default constructor:
			obj = up.newInstance();
		} catch (InstantiationException e) {
			print("Cannot instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			print("Cannot access");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
} /*
	 * Output: Class name: typeinfo.toys.FancyToy is interface? [false] Simple name:
	 * FancyToy Canonical name : typeinfo.toys.FancyToy Class name:
	 * typeinfo.toys.HasBatteries is interface? [true] Simple name: HasBatteries
	 * Canonical name : typeinfo.toys.HasBatteries Class name:
	 * typeinfo.toys.Waterproof is interface? [true] Simple name: Waterproof
	 * Canonical name : typeinfo.toys.Waterproof Class name: typeinfo.toys.Shoots is
	 * interface? [true] Simple name: Shoots Canonical name : typeinfo.toys.Shoots
	 * Class name: typeinfo.toys.Toy is interface? [false] Simple name: Toy
	 * Canonical name : typeinfo.toys.Toy
	 */// :~
