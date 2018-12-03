package szu.vander.typeinfo.registeredfactory.exercise.exercise16;

import szu.vander.typeinfo.registeredfactory.exercise.exercise16.coffee.Coffee;
import szu.vander.typeinfo.registeredfactory.exercise.exercise16.coffee.CoffeeGenerator;

/**
* @author      : Vander
* @date        : 2018-12-02
* @description ：  修改15章的Coffee继承结构，以便可以使用注册工厂
*/
public class Main {

	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
		for (Coffee c : new CoffeeGenerator(5)) {
			System.out.println(c);
		}
	}

}
