package szu.vander.generic.method.exercise.exercise16;

//: generics/TupleTest2.java
import static szu.vander.util.Tuple.tuple;

import szu.vander.util.FiveTuple;
import szu.vander.util.FourTuple;
import szu.vander.util.SixTuple;
import szu.vander.util.ThreeTuple;
import szu.vander.util.TwoTuple;

/**
 * 
* @author      : Vander
* @date        : 2018-12-11
* @description : 位Tuple.java添加一个SixTuple，并在TupleTest2.java中进行测试 
* 
 */
class Amphibian {
}

class Vehicle {
}

public class TupleTest2 {
	static TwoTuple<String, Integer> f() {
		return tuple("hi", 47);
	}

	static TwoTuple f2() {
		return tuple("hi", 47);
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
	
	static SixTuple<Vehicle, Amphibian, String, Integer, Double, Integer> v() {
		return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1, 10);
	}

	public static void main(String[] args) {
		TwoTuple<String, Integer> ttsi = f();
		System.out.println(ttsi);
		System.out.println(f2());
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
		System.out.println(v());
	}
} /*
	 * Output: (80% match) (hi, 47) (hi, 47) (Amphibian@7d772e, hi, 47)
	 * (Vehicle@757aef, Amphibian@d9f9c3, hi, 47) (Vehicle@1a46e30,
	 * Amphibian@3e25a5, hi, 47, 11.1)
	 */// :~
