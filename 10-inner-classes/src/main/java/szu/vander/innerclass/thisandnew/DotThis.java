package szu.vander.innerclass.thisandnew;

//: innerclasses/DotThis.java
// Qualifying access to the outer-class object.

/**
 * 
* @author      : Vander
* @date        : 2018-11-14
* @description ：  如果需要生成对外部类对象的引用，可以使用外部类的名字后紧跟.this。
* 				这样产生的引用自动具有正确的类型，这样编译期就能被知晓并受到检查，没有任何运行时的开销
 */
public class DotThis {
	void f() {
		System.out.println("DotThis.f()");
	}

	public class Inner {
		public DotThis outer() {
			return DotThis.this;
			// 用处应该是来直接获得外部类的属性的，像：DotThis.this.a
			// A plain "this" would be Inner's "this"
		}
	}

	public Inner inner() {
		return new Inner();
	}

	public static void main(String[] args) {
		DotThis dt = new DotThis();
		DotThis.Inner dti = dt.inner();
		dti.outer().f();
	}
} /*
	 * Output: DotThis.f()
	 */// :~
