package szu.vander.generic.compensatinglatenttyping;

import static szu.vander.util.Print.*;

//: generics/LatentReflection.java
// Using Reflection to produce latent typing.
import java.lang.reflect.Method;

import szu.vander.generic.latenttyping.Performs;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-31
 * @description: 使用反射来实现潜在类型机制，调用相应的方法的时候，找到相关类的方法，然后调用，若相关类没有该方法则抛出异常
 * 				这些类完全是彼此分离的，没有任何公共基类（除了Object类）或接口。通过反射，CommunicateReflectively.perform()
 * 				能够动态地确定所需要的方法是否可用并调用它们。它甚至能够处理Mime只具有一个必需的方这一事实，并能够部分实现其目标
 */
class Robot implements Performs {
	public void speak() {
		print("Click!");
	}

	public void sit() {
		print("Clank!");
	}

	public void oilChange() {
	}
}

// Does not implement Performs:
class Mime {
	public void walkAgainstTheWind() {
	}

	public void sit() {
		print("Pretending to sit");
	}

	public void pushInvisibleWalls() {
	}

	public String toString() {
		return "Mime";
	}
}

// Does not implement Performs:
class SmartDog {
	public void speak() {
		print("Woof!");
	}

	public void sit() {
		print("Sitting");
	}

	public void reproduce() {
	}
}

class CommunicateReflectively {
	public static void perform(Object speaker) {
		Class<?> spkr = speaker.getClass();
		try {
			try {
				Method speak = spkr.getMethod("speak");
				speak.invoke(speaker);
			} catch (NoSuchMethodException e) {
				print(speaker + " cannot speak");
			}
			try {
				Method sit = spkr.getMethod("sit");
				sit.invoke(speaker);
			} catch (NoSuchMethodException e) {
				print(speaker + " cannot sit");
			}
		} catch (Exception e) {
			throw new RuntimeException(speaker.toString(), e);
		}
	}
}

public class LatentReflection {
	public static void main(String[] args) {
		CommunicateReflectively.perform(new SmartDog());
		CommunicateReflectively.perform(new Robot());
		CommunicateReflectively.perform(new Mime());
	}
} /*
	 * Output: Woof! Sitting Click! Clank! Mime cannot speak Pretending to sit
	 */// :~
