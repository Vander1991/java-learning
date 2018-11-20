package szu.vander.container.list.practice.practice7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* @author      : Vander
* @date        : 2018-11-19
* @description ：  对subList的操作会反映到原来的List中
*/
public class ListPractice {

	public static void main(String args[]) {
		Integer[] intArr = {0, 1, 2, 3, 4, 5};
		List<Integer> intList = new ArrayList<Integer>();
		Collections.addAll(intList, intArr);
		List<Integer> subIntList = intList.subList(0, 2);
		subIntList.remove(1);
		System.out.println(intList);
	}
	
}
