package szu.vander.generic.selfboundedtype.paramcovariant;

//: generics/CovariantReturnTypes.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-24
* @description : 自限定类型的价值在于它们可以产生协变参数类型——方法参数类型会随子类而变化。
* 				协变返回类型在JDK5中引入
 */
class Base {
}

class Derived extends Base {
}

interface OrdinaryGetter {
	Base get();
}

interface DerivedGetter extends OrdinaryGetter {
	// Return type of overridden method is allowed to vary:
	Derived get();
}

public class CovariantReturnTypes {
	void test(DerivedGetter d) {
		Derived d2 = d.get();
	}
} /// :~
