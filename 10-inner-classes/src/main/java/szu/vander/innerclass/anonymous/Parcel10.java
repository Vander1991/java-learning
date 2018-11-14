package szu.vander.innerclass.anonymous;

import szu.vander.innerclass.upcast.Destination;

//: innerclasses/Parcel10.java
// Using "instance initialization" to perform
// construction on an anonymous inner class.

/**
 * 
* @author      : Vander
* @date        : 2018-11-14
* @description ：  此例中，destination的参数必须是final，因为它需要在匿名内部类中使用
* 				在实例化操作的内部，有一段代码不能作为字段初始化动作的一部分执行（就是if语句），所以对于内部类而言
* 				实例初始化的实际效果就是构造器
 */
public class Parcel10 {
	public Destination destination(final String dest, final float price) {
		return new Destination() {
			private int cost;
			// Instance initialization for each object:
			{
				cost = Math.round(price);
				if (cost > 100)
					System.out.println("Over budget!");
			}
			private String label = dest;

			public String readLabel() {
				return label;
			}
		};
	}

	public static void main(String[] args) {
		Parcel10 p = new Parcel10();
		Destination d = p.destination("Tasmania", 101.395F);
	}
} /*
	 * Output: Over budget!
	 */// :~
