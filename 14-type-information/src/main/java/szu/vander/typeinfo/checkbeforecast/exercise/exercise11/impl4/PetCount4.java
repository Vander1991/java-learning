package szu.vander.typeinfo.checkbeforecast.exercise.exercise11.impl4;

import static szu.vander.util.Print.print;
import static szu.vander.util.Print.printnb;

import szu.vander.typeinfo.checkbeforecast.exercise.exercise11.impl2.LiteralPetCreator;
import szu.vander.typeinfo.checkbeforecast.pet.Pet;
import szu.vander.util.TypeCounter;

public class PetCount4 {
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Pet.class);
		for (Pet pet : new LiteralPetCreator().createArray(20)) {
			printnb(pet.getClass().getSimpleName() + " ");
			counter.count(pet);
		}
		print();
		print(counter);
	}
} /*
	 * Output: (Sample) Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat
	 * EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
	 * {Mouse=2, Dog=6, Manx=7, EgyptianMau=2, Rodent=5, Pug=3, Mutt=3, Cymric=5,
	 * Cat=9, Hamster=1, Pet=20, Rat=2}
	 */// :~
