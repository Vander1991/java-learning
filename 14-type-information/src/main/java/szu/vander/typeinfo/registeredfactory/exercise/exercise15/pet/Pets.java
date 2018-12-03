package szu.vander.typeinfo.registeredfactory.exercise.exercise15.pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Pets {
	
	private static final RFPetCreator creator = new RFPetCreator();
	
	private static Random random = new Random(47);
	
	public static class RFPetCreator extends PetCreator {

		static List<Factory<? extends Pet>> petFactories = Arrays.asList(
				new Cat.CatFactory(), new Cymric.CymricFactory(), 
				new Dog.DogFactory(), new Manx.ManxFactory(),
				new Mouse.MouseFactory(), new Pug.PugFactory(),
				new Rat.RatFactory(), new Rodent.RodentFactory());
		
		@Override
		public List<Class<? extends Pet>> types() {
			return null;
		}
		
		@Override
		public Pet randomPet() {
			int RandomNum = random.nextInt(petFactories.size());
			return petFactories.get(RandomNum).create();
		}
		
		@Override
		public Pet[] createArray(int size) {
			Pet[] pets = new Pet[size];
			for(int i=0; i<size; i++) {
				pets[i] = randomPet();
			}
			return pets;
		}
		
		@Override
		public ArrayList<Pet> arrayList(int size) {
			ArrayList<Pet> arrayList = new ArrayList<Pet>();
			for(int i=0; i<size; i++) {
				arrayList.add(randomPet());
			}
			return arrayList;
		}
		
	}
	
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
