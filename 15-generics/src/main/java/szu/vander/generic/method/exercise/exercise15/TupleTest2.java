package szu.vander.generic.method.exercise.exercise15;

//: generics/TupleTest2.java
import static szu.vander.util.Tuple.tuple;

import szu.vander.util.FiveTuple;
import szu.vander.util.FourTuple;
import szu.vander.util.ThreeTuple;
import szu.vander.util.TwoTuple;

/**
 * 
* @author      : Vander
* @date        : 2018-12-11
* @description : 编译器并没关于f2()的警告信息，因为我们并没有将其返回值作为参数化对象使用，某种意义上，他被“向上转型”为一个非参数化
* 				的TwoTuple，然而，如果视图将f2()的返回值转型为参数化的TwoTuple，编译器就会发出警告???
 */
class Amphibian {
}

class Vehicle {
}

public class TupleTest2 {
	static TwoTuple<String, Integer> f() {
		return tuple("hi", 47);
	}

	static <K, V> TwoTuple<K, V> f2() {
		//return tuple("hi", 47);
		return null;
	}

	static ThreeTuple<Amphibian, String, Integer> g() {
		return tuple(new Amphibian(), "hi", 47);
	}

	static FourTuple<Vehicle, Amphibian, String, Integer> h() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47);
	}

	static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
	}

	public static void main(String[] args) {
		TwoTuple<String, Integer> ttsi = f();
		System.out.println(ttsi);
		System.out.println(f2());
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
	}
} /*
	 * Output: (80% match) (hi, 47) (hi, 47) (Amphibian@7d772e, hi, 47)
	 * (Vehicle@757aef, Amphibian@d9f9c3, hi, 47) (Vehicle@1a46e30,
	 * Amphibian@3e25a5, hi, 47, 11.1)
	 */// :~
