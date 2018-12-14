package szu.vander.generic.wildcard.exercise.exercise27;

import java.util.ArrayList;
import java.util.List;

/**
 * 
* @author      : Vander
* @date        : 2018-12-14
* @description : 使用Number和Integer，然后引入通配符，以此展示协变性对List不起作用
 */
public class NonCovariantGenerics {
	
	public static void main(String args[]) {
		List<? extends Number> numList = new ArrayList<Integer>();
//		numList.add(new Byte("5"));
//		numList.add(new Object());
	}
	
}
