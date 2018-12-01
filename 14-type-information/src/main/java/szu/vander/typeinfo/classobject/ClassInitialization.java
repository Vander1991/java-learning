package szu.vander.typeinfo.classobject;

//: typeinfo/ClassInitialization.java
import java.util.Random;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-01
 * @description: 仅使用.class来获得对象引用并不会引发初始化，但是用classForName就会引发初始化
 * 				如果一个static final值是“编译期常量”，就想Initable.staticFinal（直接写死了47）那样并不足以引发初始化，因为不需要初始化就知道了它是
 * 				47了，但是如果像staticFinal2那样，就会强制进行类的初始化，因为它不是一个编译期常量。
 * 				  如果一个static域不是final的，那么在对他访问时，总要求在它被读取前，要先进行链接（为这个域分配存储空间）和初始化（初始化存储空间），就像
 * 				Initable2.staticNonFinal那样
 * 
 */
class Initable {
	static final int staticFinal = 47;
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2 {
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3 {
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}

public class ClassInitialization {
	public static Random rand = new Random(47);

	public static void main(String[] args) throws Exception {
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		// Does not trigger initialization:
		System.out.println(Initable.staticFinal);
		// Does trigger initialization:
		System.out.println(Initable.staticFinal2);
		// Does trigger initialization:
		System.out.println(Initable2.staticNonFinal);
		Class initable3 = Class.forName("szu.vander.typeinfo.classobject.Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}
} /*
	 * Output: After creating Initable ref 47 Initializing Initable 258 Initializing
	 * Initable2 147 Initializing Initable3 After creating Initable3 ref 74
	 */// :~
