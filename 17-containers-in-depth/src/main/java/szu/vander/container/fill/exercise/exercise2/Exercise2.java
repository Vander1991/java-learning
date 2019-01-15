package szu.vander.container.fill.exercise.exercise2;

import java.util.HashMap;
import java.util.HashSet;

import szu.vander.container.fill.usingabstract.Countries;

/**
* @author     : Vander
* @date       : 2019-01-10
* @description: 生成一个Map和Set，使其包含所有以字母A开头的国家 
*/
public class Exercise2 {

	public static void main(String arg[]) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		HashSet<String> hashSet = new HashSet<String>();
		for(String countryName : Countries.names()) {
			if(countryName.startsWith("A")) {
				hashMap.put(countryName, Countries.capitals().get(countryName));
				hashSet.add(countryName);
			}
		}
		System.out.println(hashMap);
		System.out.println(hashSet);
	}
	
}
