package szu.vander.innerclass.insertclass;

import szu.vander.innerclass.upcast.Contents;
import szu.vander.innerclass.upcast.Destination;

//: innerclasses/Parcel11.java
// Nested classes (static inner classes).
/**
 * 
* @author      : Vander
* @date        : 2018-11-15
* @description ：  如果不需要内部类对象与其外围类对象之间的有联系，可以将内部类声明为static，这通常叫做嵌套类
* 				普通内部类对象隐式地保存了一个引用，指向创建它的外围类对象，当内部类是static的时，就不是这样了
* 				嵌套类意味着：
* 					1、要创建嵌套类的对象，并不需要其外围类的对象
* 					2、不能从嵌套类的对象中访问非静态的外围类对象
* 				嵌套类与普通内部类区别：
* 					普通内部类的字段与方法，只能放在类的外部层次上，所以普通的内部类不能有static数据与static字段，也
* 				不能包含嵌套类。但是嵌套类可以包含所有东西 
 */
public class Parcel11 {
	private static class ParcelContents implements Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	protected static class ParcelDestination implements Destination {
		private String label;

		private ParcelDestination(String whereTo) {
			label = whereTo;
		}

		public String readLabel() {
			return label;
		}

		// Nested classes can contain other static elements:
		public static void f() {
		}

		static int x = 10;

		static class AnotherLevel {
			public static void f() {
			}

			static int x = 10;
		}
	}

	public static Destination destination(String s) {
		return new ParcelDestination(s);
	}

	public static Contents contents() {
		return new ParcelContents();
	}

	public static void main(String[] args) {
		Contents c = contents();
		Destination d = destination("Tasmania");
	}
} /// :~
