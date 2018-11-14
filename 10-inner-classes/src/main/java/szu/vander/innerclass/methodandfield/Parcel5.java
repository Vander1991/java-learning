package szu.vander.innerclass.methodandfield;

import szu.vander.innerclass.upcast.Destination;

//: innerclasses/Parcel5.java
// Nesting a class within a method.

/**
 *
* @author      : Vander
* @date        : 2018-11-14
* @description ：  在方法的作用域内（而不是在其他类的作用域内）创建一个完整的类——局部内部类
* 				PDestination在方法中定义的，所以在Destination方法之外是不能访问的
 */
public class Parcel5 {
	public Destination destination(String s) {
		class PDestination implements Destination {
			private String label;

			private PDestination(String whereTo) {
				label = whereTo;
			}

			public String readLabel() {
				return label;
			}
		}
		return new PDestination(s);
	}

	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		Destination d = p.destination("Tasmania");
	}
} /// :~
