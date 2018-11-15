//: innerclasses/MultiImplementation.java
// With concrete or abstract classes, inner
// classes are the only way to produce the effect
// of "multiple implementation inheritance."
package szu.vander.innerclass.multiinherit;

/**
 * 
* @author      : Vander
* @date        : 2018-11-15
* @description : 使用内部类实现类似于多重继承的功能
 */
class D {
}

abstract class E {
}

class Z extends D {
	E makeE() {
		return new E() {
		};
	}
}

public class MultiImplementation {
	static void takesD(D d) {
	}

	static void takesE(E e) {
	}

	public static void main(String[] args) {
		Z z = new Z();
		takesD(z);
		takesE(z.makeE());
	}
} /// :~
