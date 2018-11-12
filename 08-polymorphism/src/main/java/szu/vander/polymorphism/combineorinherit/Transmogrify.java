package szu.vander.polymorphism.combineorinherit;

// Dynamically changing the behavior of an object
// via composition (the "State" design pattern).
import static szu.vander.util.Printer.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-12
* @description ：  引用在运行时可以与另一个不同的对象重新绑定起来
* 				 用继承还是用组合准则：
* 					用继承表达行为间的差异，用字段表达状态上的变化（这个例子就很好的用到了这个准则）
* 				通过继承得到两个不同的类，用于表达act()方法的差异；而Stage通过运用组合使自己的状态发生变化
 */
class Actor {
	public void act() {
	}
}

class HappyActor extends Actor {
	public void act() {
		print("HappyActor");
	}
}

class SadActor extends Actor {
	public void act() {
		print("SadActor");
	}
}

class Stage {
	private Actor actor = new HappyActor();

	public void change() {
		actor = new SadActor();
	}

	public void performPlay() {
		actor.act();
	}
}

public class Transmogrify {
	// Transmogrify->变形
	public static void main(String[] args) {
		Stage stage = new Stage();
		stage.performPlay();
		stage.change();
		stage.performPlay();
	}
} /*
	 * Output: HappyActor SadActor
	 */// :~
