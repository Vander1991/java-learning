package szu.vander.innerclass.upcast.practice.practice6.p2;

import szu.vander.innerclass.upcast.practice.practice6.p1.Shape;

/**
* @author      : Vander
* @date        : 2018-11-14
* @description ： 
*/
public class Outer {

	protected class Circle implements Shape{
		public void draw() {
			System.out.println("draw circle");
		}
	}
	
	protected Circle getCircle() {
		return new Circle();
	}
	
}
