package szu.vander.generic.compensatinglatenttyping.exercise40;

import java.util.ArrayList;

/**
* @author     : Vander
* @date       : 2019-01-01
* @description: 向typeinfo.java中的所有宠物中添加一个speak()方法。修改Apply.java，使得我们可以对
 * 				Pet的异构集合调用speak()
*/
public class Exercise40 {

	public static void main(String args[]) throws Exception {
		Apply.apply(new FilledList<Pet>(Pet.class, 5), Pet.class.getMethod("speak"));
		ArrayList<Pet> petList = new ArrayList<Pet>();
		petList.add(new Dog());
		petList.add(new Cat());
		petList.add(new Pet());
		Apply.apply(petList, Pet.class.getMethod("speak"));
	}
	
}
