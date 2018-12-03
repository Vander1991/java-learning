//: typeinfo/pets/LiteralPetCreator.java
// Using class literals.
package szu.vander.typeinfo.checkbeforecast.pet.impl2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import szu.vander.typeinfo.checkbeforecast.pet.Cat;
import szu.vander.typeinfo.checkbeforecast.pet.Cymric;
import szu.vander.typeinfo.checkbeforecast.pet.Dog;
import szu.vander.typeinfo.checkbeforecast.pet.EgyptianMau;
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
* @date        : 2018-12-02
* @description : 使用类字面常量
* 				生成Pet继承结构中的对象存在这一个问题，即每次向该继承结构添加新的
* 				Pet类型时，必须将其添加到allTypes中，如果系统中已经存在了继承
* 				结构的常规的基础，然后在其上要添加更多的类，那么就有可能会出现问题？？？？？？
 */
public class LiteralPetCreator extends PetCreator {
	// No try block needed.
	public static final List<Class<? extends Pet>> allTypes = 
			Collections.unmodifiableList(Arrays.asList(
					Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class, 
					Pug.class, EgyptianMau.class, Manx.class, Cymric.class, 
					Rat.class, Mouse.class, Hamster.class));
	// Types for random creation:
	private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class),
			allTypes.size());

	public List<Class<? extends Pet>> types() {
		return types;
	}

	public static void main(String[] args) {
		System.out.println(types);
	}
} /*
	 * Output: [class typeinfo.pets.Mutt, class typeinfo.pets.Pug, class
	 * typeinfo.pets.EgyptianMau, class typeinfo.pets.Manx, class
	 * typeinfo.pets.Cymric, class typeinfo.pets.Rat, class typeinfo.pets.Mouse,
	 * class typeinfo.pets.Hamster]
	 */// :~
