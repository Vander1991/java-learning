//: typeinfo/pets/ForNameCreator.java
package szu.vander.typeinfo.checkbeforecast.pet;

import java.util.*;

public class ForNameCreator extends PetCreator {
	private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
	// Types that you want to be randomly created:
	private static String[] typeNames = { "szu.vander.typeinfo.checkbeforecast.Mutt", "szu.vander.typeinfo.checkbeforecast.Pug", "szu.vander.typeinfo.checkbeforecast.EgyptianMau",
			"szu.vander.typeinfo.checkbeforecast.Manx", "szu.vander.typeinfo.checkbeforecast.Cymric", "szu.vander.typeinfo.checkbeforecast.Rat", "szu.vander.typeinfo.checkbeforecast.Mouse",
			"szu.vander.typeinfo.checkbeforecast.Hamster" };

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
