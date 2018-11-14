package szu.vander.innerclass.anonymous;

//: innerclasses/Parcel8.java
// Calling the base-class constructor.

/**
 * 
* @author      : Vander
* @date        : 2018-11-14
* @description ：  父类的构造方法是带参数的，匿名内部类应该这么写
 */
public class Parcel8 {
	public Wrapping wrapping(int x) {
		// Base constructor call:
		return new Wrapping(x) { // Pass constructor argument.
			public int value() {
				return super.value() * 47;
			}
		}; // Semicolon-分号 required
	}

	public static void main(String[] args) {
		Parcel8 p = new Parcel8();
		Wrapping w = p.wrapping(10);
	}
} /// :~
