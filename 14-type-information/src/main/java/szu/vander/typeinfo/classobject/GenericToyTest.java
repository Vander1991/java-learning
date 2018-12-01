//: typeinfo/toys/GenericToyTest.java
// Testing class Class.
package szu.vander.typeinfo.classobject;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-01
 * @description: 在这里使用getSuperclass获取的只能是？ super FancyToy，即使这里的超类就是Toy，但是也不允许你直接写成Toy，
 * 				也正是由于这种不确定性，所有newInstance的时候只能是Object对象，我猜想应该是有可能它的父接口会有很多个的关系，所以不允许直接写死
 */
public class GenericToyTest {
	public static void main(String[] args) throws Exception {
		Class<FancyToy> ftClass = FancyToy.class;
		// Produces exact type:
		FancyToy fancyToy = ftClass.newInstance();
		Class<? super FancyToy> up = ftClass.getSuperclass();
		// This won't compile:
		// Class<Toy> up2 = ftClass.getSuperclass();
		// Only produces Object:
		Object obj = up.newInstance();
	}
} /// :~
