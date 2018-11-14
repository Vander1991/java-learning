package szu.vander.innerclass.upcast.practice.practice6.p3;

import szu.vander.innerclass.upcast.practice.practice6.p1.Shape;
import szu.vander.innerclass.upcast.practice.practice6.p2.Outer;

/**
* @author      : Vander
* @date        : 2018-11-14
* @description ： 
*/
public class Outer2 extends Outer {

	public Shape getOuterCircle(){
		return getCircle();
	}
	
}
