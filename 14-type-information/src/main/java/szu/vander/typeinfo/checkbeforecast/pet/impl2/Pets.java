package szu.vander.typeinfo.checkbeforecast.pet.impl2;

import java.util.ArrayList;

import szu.vander.typeinfo.checkbeforecast.pet.Pet;
import szu.vander.typeinfo.checkbeforecast.pet.PetCreator;

public class Pets {
	public static final PetCreator creator = new LiteralPetCreator();

	public static Pet randomPet() {
		return creator.randomPet();
	}

	public static Pet[] createArray(int size) {
		return creator.createArray(size);
	}

	public static ArrayList<Pet> arrayList(int size) {
		return creator.arrayList(size);
	}
}
