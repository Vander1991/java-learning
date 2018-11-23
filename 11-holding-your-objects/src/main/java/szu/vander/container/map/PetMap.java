package szu.vander.container.map;

import static szu.vander.util.Print.*;

import java.util.HashMap;
import java.util.Map;

import szu.vander.container.pet.Cat;
import szu.vander.container.pet.Dog;
import szu.vander.container.pet.Hamster;
import szu.vander.container.pet.Pet;

public class PetMap {
	public static void main(String[] args) {
		Map<String, Pet> petMap = new HashMap<String, Pet>();
		petMap.put("My Cat", new Cat("Molly"));
		petMap.put("My Dog", new Dog("Ginger"));
		petMap.put("My Hamster", new Hamster("Bosco"));
		print(petMap);
		Pet dog = petMap.get("My Dog");
		print(dog);
		print(petMap.containsKey("My Dog"));
		print(petMap.containsValue(dog));
	}
} /*
	 * Output: {My Cat=Cat Molly, My Hamster=Hamster Bosco, My Dog=Dog Ginger} Dog
	 * Ginger true true
	 */// :~
