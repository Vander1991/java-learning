package szu.vander.innerclass.thisandnew;

//: innerclasses/DotNew.java
// Creating an inner class directly using the .new syntax.

/**
 * 
* @author      : Vander
* @date        : 2018-11-14
* @description ：  有时候想告知某些其他对象，去创建其某个内部类的对象。
* 				要实现此目的，必须在new表达式中提供对其他外部类对象的引用，这就需要.new了
* 				你不能这么声明dn.new DotNew.Inner()
* 				 在拥有外部类对象前是不可能创建内部类对象的，因为内部类对象会暗暗地连接到创建它的外部类对象上，如果你创建
* 				的是嵌套类（静态内部类），那么它就不需要对外部类对象的引用
 */
public class DotNew {
	public class Inner {
	}

	public static void main(String[] args) {
		DotNew dn = new DotNew();
		DotNew.Inner dni = dn.new Inner();
	}
} /// :~
