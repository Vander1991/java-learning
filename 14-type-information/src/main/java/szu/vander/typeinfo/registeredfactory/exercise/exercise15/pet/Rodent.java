//: typeinfo/pets/Rodent.java
package szu.vander.typeinfo.registeredfactory.exercise.exercise15.pet;

public class Rodent extends Pet {
	public Rodent(String name) {
		super(name);
	}

	public Rodent() {
		super();
	}
	
	static class RodentFactory implements Factory<Pet> {
		@Override
		public Pet create() {
			return new Rodent();
		}
	}
	
}
