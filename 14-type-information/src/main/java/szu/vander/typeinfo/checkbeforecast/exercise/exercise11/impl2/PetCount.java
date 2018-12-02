package szu.vander.typeinfo.checkbeforecast.exercise.exercise11.impl2;

import static szu.vander.util.Print.print;
import static szu.vander.util.Print.printnb;

import java.util.HashMap;

import szu.vander.typeinfo.checkbeforecast.exercise.exercise11.Gerbil;
import szu.vander.typeinfo.checkbeforecast.pet.Cat;
import szu.vander.typeinfo.checkbeforecast.pet.Dog;
import szu.vander.typeinfo.checkbeforecast.pet.Hamster;
import szu.vander.typeinfo.checkbeforecast.pet.Manx;
import szu.vander.typeinfo.checkbeforecast.pet.Mouse;
import szu.vander.typeinfo.checkbeforecast.pet.Mutt;
import szu.vander.typeinfo.checkbeforecast.pet.Pet;
import szu.vander.typeinfo.checkbeforecast.pet.PetCreator;
import szu.vander.typeinfo.checkbeforecast.pet.Pug;
import szu.vander.typeinfo.checkbeforecast.pet.Rat;
import szu.vander.typeinfo.checkbeforecast.pet.Rodent;

/**
 * 
* @author      : Vander
* @date        : 2018-12-01
* @description : instanceof有严格的限制：只可将其与命名类型做比较而不能与Class对象做比较
* 				如果程序中有很多的instanceof表达式，可能就说明你的设计存在缺陷
 */
public class PetCount {
	static class PetCounter extends HashMap<String, Integer> {
		private static final long serialVersionUID = 1L;

		public void count(String type) {
			Integer quantity = get(type);
			if (quantity == null)
				put(type, 1);
			else
				put(type, quantity + 1);
		}
	}

	public static void countPets(PetCreator creator) {
		PetCounter counter = new PetCounter();
		for (Pet pet : creator.createArray(20)) {
			// List each individual pet:
			printnb(pet.getClass().getSimpleName() + " ");
			if (pet instanceof Pet)
				counter.count("Pet");
			if (pet instanceof Dog)
				counter.count("Dog");
			if (pet instanceof Mutt)
				counter.count("Mutt");
			if (pet instanceof Pug)
				counter.count("Pug");
			if (pet instanceof Cat)
				counter.count("Cat");
			if (pet instanceof Manx)
				counter.count("EgyptianMau");
			if (pet instanceof Manx)
				counter.count("Manx");
			if (pet instanceof Manx)
				counter.count("Cymric");
			if (pet instanceof Rodent)
				counter.count("Rodent");
			if (pet instanceof Rat)
				counter.count("Rat");
			if (pet instanceof Mouse)
				counter.count("Mouse");
			if (pet instanceof Hamster)
				counter.count("Hamster");
			if (pet instanceof Gerbil)
				counter.count("Gerbil");
		}
		// Show the counts:
		print();
		print(counter);
	}

} /*
	 * Output: Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau
	 * Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric {Pug=3, Cat=9,
	 * Hamster=1, Cymric=7, Mouse=2, Mutt=3, Rodent=5, Pet=20, Manx=7,
	 * EgyptianMau=7, Dog=6, Rat=2}
	 */// :~
