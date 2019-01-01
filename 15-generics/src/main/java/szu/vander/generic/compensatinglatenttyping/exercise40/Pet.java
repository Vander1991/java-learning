//: typeinfo/pets/Pet.java
package szu.vander.generic.compensatinglatenttyping.exercise40;

public class Pet extends Individual {
	public Pet(String name) {
		super(name);
	}

	public Pet() {
		super();
	}
	
	public void speak() {
		System.out.println("Pet is speaking");
	}
	
} /// :~
