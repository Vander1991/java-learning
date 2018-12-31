package szu.vander.generic.dynamictypesafety;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import szu.vander.pet.Cat;
import szu.vander.pet.Dog;
import szu.vander.pet.Pet;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-30
 * @description: 使用Collections.checkedList来获得动态类型安全的List，像这种List中插入
 * 				不符合类型的数据会抛ClassCastException
 */
public class CheckedList {
	@SuppressWarnings("unchecked")
	static void oldStyleMethod(List probablyDogs) {
		probablyDogs.add(new Cat());
	}

	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<Dog>();
		oldStyleMethod(dogs1); // Quietly accepts a Cat
		List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
		try {
			oldStyleMethod(dogs2); // Throws an exception
		} catch (Exception e) {
			System.out.println(e);
		}
		// Derived types work fine:
		List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
		pets.add(new Dog());
		pets.add(new Cat());
	}
} /*
	 * Output: java.lang.ClassCastException: Attempt to insert class
	 * typeinfo.pets.Cat element into collection with element type class
	 * typeinfo.pets.Dog
	 */// :~
