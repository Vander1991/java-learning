//: typeinfo/pets/Cat.java
package szu.vander.typeinfo.registeredfactory.exercise.exercise15.pet;

public class Cat extends Pet {
	public Cat(String name) {
		super(name);
	}

	public Cat() {
		super();
	}
	
	static class CatFactory implements Factory<Pet> {
		@Override
		public Pet create() {
			return new Cat();
		}
	}
	
}
