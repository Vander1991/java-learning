package szu.vander.innerclass.override;

//: innerclasses/BigEgg2.java
// Proper inheritance of an inner class.
import static szu.vander.util.Print.print;

/**
 * 
* @author      : Vander
* @date        : 2018-11-16
* @description : 内部类不能被覆盖，这是因为这两个内部类是完全独立的两个实体，各自在自己的命名空间内。
* 				要覆盖的话除非明确继承某个内部类
 */
class Egg2 {
	protected class Yolk {
		public Yolk() {
			print("Egg2.Yolk()");
		}

		public void f() {
			print("Egg2.Yolk.f()");
		}
	}

	private Yolk y = new Yolk();

	public Egg2() {
		print("New Egg2()");
	}

	public void insertYolk(Yolk yy) {
		y = yy;
	}

	public void g() {
		y.f();
	}
}

public class BigEgg2 extends Egg2 {
	public class Yolk extends Egg2.Yolk {
		public Yolk() {
			print("BigEgg2.Yolk()");
		}

		public void f() {
			print("BigEgg2.Yolk.f()");
		}
	}

	public BigEgg2() {
		insertYolk(new Yolk());
	}

	public static void main(String[] args) {
		Egg2 e2 = new BigEgg2();
		e2.g();
	}
} /*
	 * Output: Egg2.Yolk() New Egg2() Egg2.Yolk() BigEgg2.Yolk() BigEgg2.Yolk.f()
	 */// :~
