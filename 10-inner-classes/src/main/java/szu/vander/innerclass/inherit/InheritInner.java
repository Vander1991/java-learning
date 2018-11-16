package szu.vander.innerclass.inherit;

//: innerclasses/InheritInner.java
// Inheriting an inner class.

/**
 * 
* @author      : Vander
* @date        : 2018-11-16
* @description : 内部类的继承：
* 				内部类的构造器必须连接到指向其外围类对象的引用，所以在继承内部类的时候，变得复杂，问题在于，指向外围类对象
* 				“秘密的”引用必须被初始化，而在到处类中不在存在可连接的默认对象，这样就必须用特殊的语法来说清它们间的关联
* 				InheritInner只继承内部类而不是外围类，但是当要生成一个构造器时，默认构造器不算好，不能只是传递一个
* 				指向外围类对象的引用，必须在构造器中使用
* 					enclosingClassReference.super();
 */
class WithInner {
	class Inner {
	}
}

public class InheritInner extends WithInner.Inner {
	// ! InheritInner() {} // Won't compile
	InheritInner(WithInner wi) {
		wi.super();
	}

	public static void main(String[] args) {
		WithInner wi = new WithInner();
		InheritInner ii = new InheritInner(wi);
	}
} /// :~
