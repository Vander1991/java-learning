//: typeinfo/pets/Mouse.java
package szu.vander.typeinfo.registeredfactory.exercise.exercise15.pet;

public class Mouse extends Rodent {
	public Mouse(String name) {
		super(name);
	}

	public Mouse() {
		super();
	}
	
	static class MouseFactory implements Factory<Pet> {
		@Override
		public Pet create() {
			return new Mouse();
		}
	}
	
}
