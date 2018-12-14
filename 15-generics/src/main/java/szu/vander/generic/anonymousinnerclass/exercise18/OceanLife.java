package szu.vander.generic.anonymousinnerclass.exercise18;

import java.util.ArrayList;
import java.util.Random;

import szu.vander.util.Generator;
import szu.vander.util.Generators;

/**
* @author      : Vander
* @date        : 2018-12-11
* @description ： 
*/
class BigFish {

	private static int counter = 0;
	
	private final int fishId = counter++;
	
	private BigFish() {
	}
	
	public String toString() {
		return "BigFish" + fishId;
	}
	
	public static Generator<BigFish> generator() {
		return new Generator<BigFish>() {
			@Override
			public BigFish next() {
				return new BigFish();
			}
		};
	}

}

class LittleFish {

	private static int counter = 0;
	
	private final int fishId = counter++;
	
	private LittleFish() {
	}
	
	public String toString() {
		return "LittleFish" + fishId;
	}
	
	public static Generator<LittleFish> generator() {
		return new Generator<LittleFish>() {
			@Override
			public LittleFish next() {
				return new LittleFish();
			}
		};
	}

}

public class OceanLife {

	public static void eat(BigFish bigFish, LittleFish littleFish) {
		System.out.println(bigFish + " eat " + littleFish);
	}
	
	public static void main(String args[]) {
		ArrayList<BigFish> bigFishList = new ArrayList<BigFish>();
		Generators.fill(bigFishList, BigFish.generator(), 10);
		ArrayList<LittleFish> littleFishList = new ArrayList<LittleFish>();
		Generators.fill(littleFishList, LittleFish.generator(), 5);
		Random random = new Random(47);
		for(LittleFish littleFish : littleFishList) {
			int randomNum = random.nextInt(bigFishList.size());
			eat(bigFishList.get(randomNum), littleFish);
		}
	}
	
}
