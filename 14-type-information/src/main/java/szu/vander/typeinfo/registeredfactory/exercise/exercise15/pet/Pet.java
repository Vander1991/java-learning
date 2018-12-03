//: typeinfo/pets/Pet.java
package szu.vander.typeinfo.registeredfactory.exercise.exercise15.pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pet extends Individual {
	
	static List<Factory<? extends Pet>> partFactories = new ArrayList<Factory<? extends Pet>>();
	
	static {
		Collections.addAll(partFactories, new Cat.CatFactory(),
				new Cymric.CymricFactory(), new Dog.DogFactory(),
				new Manx.ManxFactory(), new Mouse.MouseFactory(),
				new Pug.PugFactory(), new Rat.RatFactory(),
				new Rodent.RodentFactory());
	}
	
	public Pet(String name) {
		super(name);
	}

	public Pet() {
		super();
	}
}
