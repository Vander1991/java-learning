//: typeinfo/pets/PetCreator.java
// Creates random sequences of Pets.
package szu.vander.typeinfo.registeredfactory.exercise.exercise15.pet;

import java.util.*;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-01
 * @description: newInstance方法会产生两个异常，一个是IllegalAccessException，这个主要是构造器为私有的时候会抛
 */
public abstract class PetCreator {
	private Random rand = new Random(47);

	// The List of the different types of Pet to create:
	public abstract List<Class<? extends Pet>> types();

	public Pet randomPet() { // Create one random Pet
		int n = rand.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public Pet[] createArray(int size) {
		Pet[] result = new Pet[size];
		for (int i = 0; i < size; i++) {
			result[i] = randomPet();
		}
		return result;
	}

	public ArrayList<Pet> arrayList(int size) {
		ArrayList<Pet> result = new ArrayList<Pet>();
		Collections.addAll(result, createArray(size));
		return result;
	}
}
