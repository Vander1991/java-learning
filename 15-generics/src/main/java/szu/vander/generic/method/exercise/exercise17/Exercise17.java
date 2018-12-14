package szu.vander.generic.method.exercise.exercise17;

import static szu.vander.generic.method.Watercolors.BRILLIANT_RED;
import static szu.vander.generic.method.Watercolors.BURNT_UMBER;
import static szu.vander.generic.method.Watercolors.CERULEAN_BLUE_HUE;
import static szu.vander.generic.method.Watercolors.VIRIDIAN_HUE;
import static szu.vander.util.Print.print;

import java.util.EnumSet;
import java.util.Set;

import szu.vander.generic.method.Watercolors;

/**
* @author      : Vander
* @date        : 2018-12-11
* @description ：   
*/
public class Exercise17 {

	public static void main(String[] args) {
		Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
		Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
		print("set1: " + set1);
		print("set2: " + set2);
		print("union(set1, set2): " + Sets2.union(set1, set2));
	}

}
