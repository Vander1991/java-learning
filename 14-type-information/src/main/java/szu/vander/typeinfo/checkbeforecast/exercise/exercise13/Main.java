package szu.vander.typeinfo.checkbeforecast.exercise.exercise13;

import szu.vander.util.TypeCounter;

/**
* @author      : Vander
* @date        : 2018-12-02
* @description ： 
*/
public class Main {

	public static void main(String[] args) {
		Part part = new Part();
		TypeCounter typeCounter = new TypeCounter(Part.class);
		for(int i=0; i<20 ;i++) {
			typeCounter.count(part.createRandom());
		}
		System.out.println(typeCounter);
	}

}
