//: typeinfo/pets/Dog.java
package szu.vander.generic.compensatinglatenttyping.exercise40;

public class Dog extends Pet {
	public Dog(String name) {
		super(name);
	}

	public Dog() {
		super();
	}
	
	public void speak() {
		System.out.println("Dog is speaking");
	}
	
} /// :~
