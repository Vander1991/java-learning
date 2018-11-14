package szu.vander.innerclass.upcast;

//: innerclasses/TestParcel.java

/**
 * 
* @author      : Vander
* @date        : 2018-11-14
* @description ：  PContent和PDestination实现了外部接口，但是外部对这两个类是不可见的，没法new，客户端需要调用
* 				的时候只能通过外部类的content()方法等来获得接口的实例，这样方便屏蔽实现细节
* 				 private内部类给类的设计者提供了一种途径，通过这种方式可以完全阻止任何依赖于类型的编码，并且完全隐藏了
* 				实现的细节。从客户端程序员的角度来看，由于不能访问任何新增加的、原本不属于公共接口的方法，所以扩展接口是没有
* 				价值的。这也给Java编译器提供了生成更高效代码的机会
 */
class Parcel4 {
	private class PContents implements Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	protected class PDestination implements Destination {
		private String label;

		private PDestination(String whereTo) {
			label = whereTo;
		}

		public String readLabel() {
			return label;
		}
	}

	public Destination destination(String s) {
		return new PDestination(s);
	}

	public Contents contents() {
		return new PContents();
	}
}

public class TestParcel {
	public static void main(String[] args) {
		Parcel4 p = new Parcel4();
		Contents c = p.contents();
		Destination d = p.destination("Tasmania");
		// Illegal -- can't access private class:
		// ! Parcel4.PContents pc = p.new PContents();
	}
} /// :~
