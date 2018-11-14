package szu.vander.innerclass.anonymous;

import szu.vander.innerclass.upcast.Contents;

//: innerclasses/Parcel7.java
// Returning an instance of an anonymous inner class.
/**
 * 
* @author      : Vander
* @date        : 2018-11-14
* @description ：  创建了一个实现Contents接口的对象
 */
public class Parcel7 {
	public Contents contents() {
		return new Contents() { // Insert a class definition
			private int i = 11;

			public int value() {
				return i;
			}
		}; // Semicolon required in this case,分号是标志着表达式的结束
	}

	public static void main(String[] args) {
		Parcel7 p = new Parcel7();
		Contents c = p.contents();
	}
} /// :~
