package szu.vander.generic.erasurecompensate.exercise.exercise24;

import java.util.HashMap;
import java.util.Map;

/**
 * 
* @author      : Vander
* @date        : 2018-12-12
* @description : 修改练习21，将Map<Stirng, Class<?>>改为Map<String, IFactory<?>>
 */
interface IFactory<T> {
	T create();
}

class Building {
	Building() {
		System.out.println("Building()");
	}
	
	static class factory implements IFactory<Building> {
		@Override
		public Building create() {
			return new Building();
		}
	}
	
}

class House extends Building {
	
	House() {
		System.out.println("House()");
	}
	
	static class factory implements IFactory<House> {
		@Override
		public House create() {
			return new House();
		}
	}
	
}

public class ClassTypeCapture<T> {

	private Map<String, IFactory<T>> types = new HashMap<String, IFactory<T>>();
	
	public void addType(String typename, IFactory<T> kind) {
		types.put(typename, kind);
	}
	
	public T createNew(String typename) {
		return types.get(typename).create();
	}
	
	public static void main(String[] args) {
		ClassTypeCapture<Building> buildingClassTypeCapture = new ClassTypeCapture<Building>();
		buildingClassTypeCapture.addType("Building", new Building.factory());
		ClassTypeCapture<House> houseClassTypeCapture = new ClassTypeCapture<House>();
		houseClassTypeCapture.addType("House", new House.factory());
		Building building = buildingClassTypeCapture.createNew("Building");
		House house = houseClassTypeCapture.createNew("House");
	}
} /*
	 * Output: true true false true
	 */// :~
