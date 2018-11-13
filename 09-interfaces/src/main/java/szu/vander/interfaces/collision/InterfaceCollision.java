//: interfaces/InterfaceCollision.java
package szu.vander.interfaces.collision;

/**
 * 
* @author      : Vander
* @date        : 2018-11-13
* @description ：  打算组合不同接口中使用相同的方法名通常会造成代码可读性混乱，尽量避免这种情况
 */
interface I1 {
	void f();
}

interface I2 {
	int f(int i);
}

interface I3 {
	int f();
}

class C {
	public int f() {
		return 1;
	}
}

class C2 implements I1, I2 {
	public void f() {
	}

	public int f(int i) {
		return 1;
	} // overloaded
}

class C3 extends C implements I2 {
	public int f(int i) {
		return 1;
	} // overloaded
}

class C4 extends C implements I3 {
	// Identical, no problem:
	public int f() {
		return 1;
	}
}

// Methods differ only by return type:
//! class C5 extends C implements I1 {}
//! interface I4 extends I1, I3 {}
