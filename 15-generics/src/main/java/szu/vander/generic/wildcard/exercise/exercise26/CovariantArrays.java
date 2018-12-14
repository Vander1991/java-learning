package szu.vander.generic.wildcard.exercise.exercise26;

//: generics/CovariantArrays.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-14
* @description : 使用Number和Integer证明数组的协变性
 */

public class CovariantArrays {
	public static void main(String[] args) {
		Number[] nums = new Integer[10];
		nums[0] = new Byte("10");
	}
}