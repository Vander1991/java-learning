package szu.vander.generic.selfboundedtype.paramcovariant;

//: generics/SelfBoundingAndCovariantArguments.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-28
* @description ：在使用自限定类型时，在子类中只有一个方法，并且这个方法接收导出类型而不是基类型为参数
 */
interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
	void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {
}

public class SelfBoundingAndCovariantArguments {
	void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
		s1.set(s2);
		// s1.set(sbs); // Error:
		// set(Setter) in SelfBoundSetter<Setter>
		// cannot be applied to (SelfBoundSetter)
	}
} /// :~
