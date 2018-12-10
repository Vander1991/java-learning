package szu.vander.typeinfo.nullobject.exercise24;
/**
* @author      : Vander
* @date        : 2018-12-09
* @description ： 在RegisteredFactories.java中添加空对象
*/
public class Exercise24 {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			IPart part = Part.createRandom();
			// Real object
			System.out.println(part);
			// Null companion
			System.out.println(Part.newNull(part.getClass()));
		}
	}
	
}
