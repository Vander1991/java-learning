package szu.vander.finaltest;

/**
 * 
 * @author : Vander
 * @date : 2018-11-10
 * @description: 在方法的参数中使用final,让你可以读参数但无法改变参数，这一特性常用来向匿名内部类传递数据
 */

public class FinalArguments {
	void with(final Gizmo g) {
		// ! g = new Gizmo(); // Illegal -- g is final
	}

	void without(Gizmo g) {
		g = new Gizmo(); // OK -- g not final
		g.spin();
	}

	// void f(final int i) { i++; } // Can't change
	// You can only read from a final primitive:
	int g(final int i) {
		return i + 1;
	}

	public static void main(String[] args) {
		FinalArguments bf = new FinalArguments();
		bf.without(null);
		bf.with(null);
	}
}

class Gizmo {
	public void spin() {
	}
}
