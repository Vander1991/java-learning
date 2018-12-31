package szu.vander.generic.selfboundedtype.crgdemo;

//: generics/CRGWithBasicHolder.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-23
* @description : Java中的泛型关注的是参数和返回类型，因此它能够产生使用子类作为其参数和返回类型
* 				甚至是域的基类，看下面的例子基类是BasicHolder而子类是Subtype，这里将Subtype作为T
* 				这样BasicHolder中的参数和返回类型以及域都是子类了
*  					新类的subType接受的参数和返回值具有Subtype类型而不仅仅是基类BasicHolder类型
* 				这就是CRG的本质:基类用导出类替代其参数。这意味着泛型基类变成一种其所有导出类的公共功能的模板
* 				但是这些功能对于其所有参数和返回值，将使用导出类？？？
 */
class Subtype extends BasicHolder<Subtype> {
}

public class CRGWithBasicHolder {
	public static void main(String[] args) {
		Subtype st1 = new Subtype(), 
				st2 = new Subtype();
		st1.set(st2);
		Subtype st3 = st1.get();
		st1.f();
	}
} /*
	 * Output: Subtype
	 */// :~
