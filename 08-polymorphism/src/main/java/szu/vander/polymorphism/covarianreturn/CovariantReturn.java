package szu.vander.polymorphism.covarianreturn;

/**
 * 
* @author      : Vander
* @date        : 2018-11-12
* @description ：  这里所谓的协变返回类型的意思实际上是小麦工厂生成的小麦向上转型成谷物，但是仍旧是小麦的属性
* 				 Java早期版本中将强制process()的覆盖版本必须返回Grain，而不能返回Wheat，尽管Wheat是
* 				   从Grain导出的。
 */
class Grain {
	public String toString() {
		// 谷类
		return "Grain";
	}
}

class Wheat extends Grain {
	public String toString() {
		// 小麦
		return "Wheat";
	}
}


class Mill {
	// 工厂
	Grain process() {
		return new Grain();
	}
}

class WheatMill extends Mill {
	Wheat process() {
		return new Wheat();
	}
}

public class CovariantReturn {
	public static void main(String[] args) {
		Mill m = new Mill();
		Grain g = m.process();
		System.out.println(g);
		m = new WheatMill();
		g = m.process();
		System.out.println(g);
	}
} /*
	 * Output: Grain Wheat
	 */// :~
