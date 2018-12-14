//: generics/coffee/Americano.java
package szu.vander.generic.interfaces.coffee;

public class Americano extends Coffee {

	static class CoffeeFactory implements Factory<Coffee> {
		@Override
		public Coffee create() {
			return new Americano();
		}
	}
	
}
