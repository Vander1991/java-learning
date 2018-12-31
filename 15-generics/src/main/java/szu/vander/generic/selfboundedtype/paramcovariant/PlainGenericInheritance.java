package szu.vander.generic.selfboundedtype.paramcovariant;

//: generics/PlainGenericInheritance.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-28
* @description ：不使用自限定类型，普通的继承机制就会介入，而你将能够重载，就像在非泛型的情况下一样
* 				总结：
* 					如果不使用自限定，将重载参数类型，如果使用了自限定，只能获得某个方法的一个版本，
* 				它将接受确切的参数类型。
 */
class GenericSetter<T> { // Not self-bounded
	void set(T arg) {
		System.out.println("GenericSetter.set(Base)");
	}
}

class DerivedGS extends GenericSetter<Base> {
	void set(Derived derived) {
		System.out.println("DerivedGS.set(Derived)");
	}
}

public class PlainGenericInheritance {
	public static void main(String[] args) {
		Base base = new Base();
		Derived derived = new Derived();
		DerivedGS dgs = new DerivedGS();
		dgs.set(derived);
		dgs.set(base); // Compiles: overloaded, not overridden!
	}
} /*
	 * Output: DerivedGS.set(Derived) GenericSetter.set(Base)
	 */// :~
