package szu.vander.finaltest;

//: reusing/FinalOverridingIllusion.java
// It only looks like you can override
// a private or private final method.
import static szu.vander.util.Printer.*;

/**
 * 
 * @author : Vander
 * @date : 2018-11-10
 * @description: 方法定义为final的原因从前有两种： 1、为了将方法锁定，不允许继承类修改它的含义 2、为了提高效率
 */
public class FinalOverridingIllusion {
	public static void main(String[] args) {
		OverridingPrivate2 op2 = new OverridingPrivate2();
		op2.f();
		op2.g();
		// You can upcast:
		OverridingPrivate op = op2;
		// But you can't call the methods:
		// op.f(); //由于方法定义成private所以不能调用
		// op.g();
		// Same here:
		WithFinals wf = op2;
		// ! wf.f();
		// ! wf.g();
	}
}

class WithFinals {
	// Identical to "private" alone:
	private final void f() {
		print("WithFinals.f()");
	}

	// Also automatically "final":
	private void g() {
		print("WithFinals.g()");
	}
}

class OverridingPrivate extends WithFinals {
	
	//@Override 使用Override注解就知道这不是重写了
	private final void f() {
		print("OverridingPrivate.f()");
	}

	private void g() {
		print("OverridingPrivate.g()");
	}
}

class OverridingPrivate2 extends OverridingPrivate {
	public final void f() {
		print("OverridingPrivate2.f()");
	}

	public void g() {
		print("OverridingPrivate2.g()");
	}
}

/**
 * 基类方法中用private
 * final修饰是没有意义的，因为你本身就private了，子类都无法重写这个方法了（说明此时private本身隐含了final）
 * 如果确实这么定义了，子类重写这个方法时，实际上不是重写了，而是定义了一个跟父类同名的方法罢了。
 */