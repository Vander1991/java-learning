//: typeinfo/pets/Cat.java
package szu.vander.generic.compensatinglatenttyping.exercise40;

public class Cat extends Pet {
	public Cat(String name) {
		super(name);
	}

	public Cat() {
		super();
	}
	
	public void speak() {
		System.out.println("Cat is speaking");
	}
	
} /// :~
