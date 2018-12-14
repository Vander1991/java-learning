//: generics/coffee/Mocha.java
package szu.vander.generic.interfaces.coffee;

public class Mocha extends Coffee {

	static class CoffeeFactory implements Factory<Coffee> {
		@Override
		public Coffee create() {
			return new Mocha();
		}
	}
	
}
