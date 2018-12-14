package szu.vander.generic.simple.exercise.exercise3;
/**
* @author      : Vander
* @date        : 2018-12-10
* @description ： 
*/

import szu.vander.util.FiveTuple;

/**
 * 
* @author      : Vander
* @date        : 2018-12-10
* @description : 使用泛型编写一个SixTuple类并测试它
 */
public class Exercise3 {

	static FiveTuple<Boolean, Character, Byte, Integer, Long> testFiveTuple(boolean a, char b, byte c, int d, long e) {
		return new FiveTuple<Boolean, Character, Byte, Integer, Long>(a, b, c, d, e);
	}
	
	public static void main(String args[]) {
		System.out.println(testFiveTuple(true, 'a', (byte)8, 16, 32));
	}
	
}
