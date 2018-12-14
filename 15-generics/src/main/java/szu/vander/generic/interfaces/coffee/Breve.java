//: generics/coffee/Breve.java
package szu.vander.generic.interfaces.coffee;

public class Breve extends Coffee {

	static class CoffeeFactory implements Factory<Coffee> {
		@Override
		public Coffee create() {
			return new Breve();
		}
	}
}
