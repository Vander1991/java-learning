//: generics/coffee/Americano.java
package szu.vander.typeinfo.registeredfactory.exercise.exercise16.coffee;

public class Americano extends Coffee {

	static class CoffeeFactory implements Factory<Coffee> {
		@Override
		public Coffee create() {
			return new Americano();
		}
	}
	
}
