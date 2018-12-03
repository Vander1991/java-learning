//: generics/coffee/Coffee.java
package szu.vander.typeinfo.registeredfactory.exercise.exercise16.coffee;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Coffee {
	
	private static long counter = 0;
	
	private static Random rand = new Random(47);
	
	private static List<Factory<? extends Coffee>> types = Arrays.asList(  
			new Latte.CoffeeFactory(), new Mocha.CoffeeFactory(), 
			new Cappuccino.CoffeeFactory(), new Americano.CoffeeFactory(), 
			new Breve.CoffeeFactory());

	public static Coffee createRandom() {
		try {
			int randomNum = rand.nextInt(types.size());
			return types.get(randomNum).create();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private final long id = counter++;

	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
	
}
