//: typeinfo/pets/Dog.java
package szu.vander.typeinfo.registeredfactory.exercise.exercise15.pet;

public class Dog extends Pet {
	public Dog(String name) {
		super(name);
	}

	public Dog() {
		super();
	}
	
	static class DogFactory implements Factory<Pet> {
		@Override
		public Pet create() {
			return new Dog();
		}
	}
	
} 
