package szu.vander.typeinfo.checkbeforecast.exercise.exercise12;

import szu.vander.util.TypeCounter;

/**
* @author      : Vander
* @date        : 2018-12-02
* @description ： 
*/
public class Main {

	public static void main(String args[]) {
		CoffeeGenerator coffeeGenerator = new CoffeeGenerator(10);
		TypeCounter typeCounter = new TypeCounter(Coffee.class);
		for(Coffee coffee : coffeeGenerator) {
			typeCounter.count(coffee);
		}
		System.out.println(typeCounter);
	}
	
}
