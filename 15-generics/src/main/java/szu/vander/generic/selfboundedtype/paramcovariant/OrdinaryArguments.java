package szu.vander.generic.selfboundedtype.paramcovariant;

//: generics/OrdinaryArguments.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-25
* @description : set(Base base)和set(Derived derived)都是合法的，因此DerivedSetter.set()没有覆盖
* 				OrdinarySetter.set()，而是重载了这个方法，但是使用自限定类型，在导出类中只有一个方
* 				法，并且接受导出类型而不是基类型为参数，详见SelfBoundingAndCovariantArguments.java
 */
class OrdinarySetter {
	void set(Base base) {
		System.out.println("OrdinarySetter.set(Base)");
	}
}

class DerivedSetter extends OrdinarySetter {
	void set(Derived derived) {
		System.out.println("DerivedSetter.set(Derived)");
	}
}

public class OrdinaryArguments {
	public static void main(String[] args) {
		Base base = new Base();
		Derived derived = new Derived();
		DerivedSetter ds = new DerivedSetter();
		ds.set(derived);
		ds.set(base); // Compiles: overloaded, not overridden!
	}
} /*
	 * Output: DerivedSetter.set(Derived) OrdinarySetter.set(Base)
	 */// :~
