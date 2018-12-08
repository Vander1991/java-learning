//: typeinfo/toys/ToyTest.java
// Testing class Class.
package szu.vander.typeinfo.reflect.exercise.exercise19;

import static szu.vander.util.Print.print;

/**
 * 
* @author      : Vander
* @date        : 2018-11-30
* @description : 使用反射机制通过非默认构造器创建Toy对象 
* 
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
		print("Constructor Toy(" + i + ")");
	}
}

public class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	
	private int i;
	
	public FancyToy() {
		super();
	}
	
	public FancyToy(int i){
		super(i);
		this.i = i;
	}
	
	public String toString() {
		return "FancyToy(" + i + ")";
	}
	

	
}
