//: typeinfo/pets/Pug.java
package szu.vander.typeinfo.registeredfactory.exercise.exercise15.pet;

public class Pug extends Dog {
	public Pug(String name) {
		super(name);
	}

	public Pug() {
		super();
	}
	
	static class PugFactory implements Factory<Pet> {
		@Override
		public Pet create() {
			return new Pug();
		}
	}
	
} 
