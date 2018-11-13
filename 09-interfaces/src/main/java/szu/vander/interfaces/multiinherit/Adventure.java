package szu.vander.interfaces.multiinherit;

// Multiple interfaces.

/**
 * 
 * @author : Vander
 * @date : 2018-11-13
 * @description ：当Hero对象被创建时，它可以传递给这些方法中的任何一个，这意味着它依次被向上转型为每个接口，Java由于
 * 				这种接口设计的方式，使得这项工作并不需要程序员付出额外地努力
 * 				使用接口两个原因：
 * 					1、为了能向上转型为多个基类型（以此带来的灵活性）
 * 					2、防止客户端程序员创建该类的对象，并确保这仅仅是建立一个接口？？？
 */
interface CanFight {
	void fight();
}

interface CanSwim {
	void swim();
}

interface CanFly {
	void fly();
}

class ActionCharacter {
	public void fight() {
	}
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {
	public void swim() {
	}

	public void fly() {
	}
}

public class Adventure {
	public static void t(CanFight x) {
		x.fight();
	}

	public static void u(CanSwim x) {
		x.swim();
	}

	public static void v(CanFly x) {
		x.fly();
	}

	public static void w(ActionCharacter x) {
		x.fight();
	}

	public static void main(String[] args) {
		Hero h = new Hero();
		t(h); // Treat it as a CanFight
		u(h); // Treat it as a CanSwim
		v(h); // Treat it as a CanFly
		w(h); // Treat it as an ActionCharacter
	}
}
