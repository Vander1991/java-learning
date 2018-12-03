package szu.vander.typeinfo.registeredfactory.exercise.exercise15;

import java.util.List;

import szu.vander.typeinfo.registeredfactory.exercise.exercise15.pet.Pet;
import szu.vander.typeinfo.registeredfactory.exercise.exercise15.pet.Pets;

/**
* @author      : Vander
* @date        : 2018-12-02
* @description ： 使用注册工厂来实现一个新的PetCreator，并修改Pets外观，使其使用新的Creator而并非另外两个Creator。
* 				确保使用Pets.java的其他实例仍能正常工作。
*/
public class Main {

	public static void main(String[] args) {
		Pets pets = new Pets();
		List<Pet> petList = pets.arrayList(10);
		System.out.println(petList);
	}

}
