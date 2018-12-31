package szu.vander.generic.latenttyping;

//: generics/SimpleDogsAndRobots.java
// Removing the generic; code still works.

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-31
 * @description: 相对于DogsAndRobots.java，实际上perform()不需要使用泛型来工作，可以被简单指定为接受一个Performs对象
 */
class CommunicateSimply {
	static void perform(Performs performer) {
		performer.speak();
		performer.sit();
	}
}

public class SimpleDogsAndRobots {
	public static void main(String[] args) {
		CommunicateSimply.perform(new PerformingDog());
		CommunicateSimply.perform(new Robot());
	}
} /*
	 * Output: Woof! Sitting Click! Clank!
	 */// :~
