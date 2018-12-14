//: generics/coffee/Cappuccino.java
package szu.vander.generic.interfaces.coffee;

public class Cappuccino extends Coffee {

	static class CoffeeFactory implements Factory<Coffee> {
		@Override
		public Coffee create() {
			return new Cappuccino();
		}
	}
} 
