//: typeinfo/pets/Rat.java
package szu.vander.typeinfo.registeredfactory.exercise.exercise15.pet;

public class Rat extends Rodent {
	public Rat(String name) {
		super(name);
	}

	public Rat() {
		super();
	}
	
	static class RatFactory implements Factory<Pet> {
		@Override
		public Pet create() {
			return new Rat();
		}
	}
	
}
