//: typeinfo/pets/ForNameCreator.java
package szu.vander.typeinfo.checkbeforecast.pet.impl1;

import java.util.*;

import szu.vander.typeinfo.checkbeforecast.pet.Pet;
import szu.vander.typeinfo.checkbeforecast.pet.PetCreator;

/**
 * 
* @author      : Vander
* @date        : 2018-12-02
* @description : 使用Class.ForName创建Class对象
 */
public class ForNameCreator extends PetCreator {
	private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
	// Types that you want to be randomly created:
	private static String[] typeNames = { 
			"szu.vander.typeinfo.checkbeforecast.pet.Mutt", 
			"szu.vander.typeinfo.checkbeforecast.pet.Pug", 
			"szu.vander.typeinfo.checkbeforecast.pet.EgyptianMau",
			"szu.vander.typeinfo.checkbeforecast.pet.Manx", 
			"szu.vander.typeinfo.checkbeforecast.pet.Cymric", 
			"szu.vander.typeinfo.checkbeforecast.pet.Rat", 
			"szu.vander.typeinfo.checkbeforecast.pet.Mouse",
			"szu.vander.typeinfo.checkbeforecast.pet.Hamster" };

	@SuppressWarnings("unchecked")
	private static void loader() {
		try {
			for (String name : typeNames) {
				types.add((Class<? extends Pet>) Class.forName(name));
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	static {
		loader();
	}

	public List<Class<? extends Pet>> types() {
		return types;
	}
} /// :~
