//: typeinfo/pets/Manx.java
package szu.vander.typeinfo.registeredfactory.exercise.exercise15.pet;

public class Manx extends Cat {
	public Manx(String name) {
		super(name);
	}

	public Manx() {
		super();
	}
	
	static class ManxFactory implements Factory<Pet> {
		@Override
		public Pet create() {
			return new Manx();
		}
	}
	
} 
