//: typeinfo/pets/Cymric.java
package szu.vander.typeinfo.registeredfactory.exercise.exercise15.pet;

public class Cymric extends Manx {
	public Cymric(String name) {
		super(name);
	}

	public Cymric() {
		super();
	}
	
	static class CymricFactory implements Factory<Pet> {
		@Override
		public Pet create() {
			return new Cymric();
		}
	}
	
}
