package szu.vander.innerclass.anonymous;

import szu.vander.innerclass.upcast.Destination;

//: innerclasses/Parcel9.java
// An anonymous inner class that performs
// initialization. A briefer version of Parcel5.java.
/**
 * 
* @author      : Vander
* @date        : 2018-11-14
* @description ：  如果定义一个匿名内部类，并且希望它使用一个在其外部定义的对象，那么编译器会要求其参数引用是final的，
* 				就像你在destination()的参数中看到的那样。如果忘记了，编译会出错???
 */
public class Parcel9 {
	// Argument must be final to use inside
	// anonymous inner class:
	public Destination destination(final String dest) {
		return new Destination() {
			private String label = dest;

			public String readLabel() {
				return label;
			}
		};
	}

	public static void main(String[] args) {
		Parcel9 p = new Parcel9();
		Destination d = p.destination("Tasmania");
	}
} /// :~
