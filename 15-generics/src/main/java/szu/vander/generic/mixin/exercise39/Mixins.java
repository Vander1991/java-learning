package szu.vander.generic.mixin.exercise39;

//: generics/Mixins.java
import java.util.*;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-30
 * @description: 一种更常见的推荐解决方案是使用接口来产生混型效果
 * 				Mixin类基本上是在使用代理，因此每个混入类型都要求在Mixin中有一个相应的域，而你必须在Mixin中编写所有必须的方法，
 * 				将方法调用转发给恰当的对象
 */
interface TimeStamped {
	long getStamp();
}

class TimeStampedImp implements TimeStamped {
	private final long timeStamp;

	public TimeStampedImp() {
		timeStamp = new Date().getTime();
	}

	public long getStamp() {
		return timeStamp;
	}
}

interface SerialNumbered {
	long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
	private static long counter = 1;
	private final long serialNumber = counter++;

	public long getSerialNumber() {
		return serialNumber;
	}
}

interface Basic {
	public void set(String val);

	public String get();
}

interface Colored {
	String colored();
}

class ColoredImpl implements Colored {

	@Override
	public String colored() {
		return "basic colored";
	}
	
}

class BasicImp implements Basic {
	private String value;

	public void set(String val) {
		value = val;
	}

	public String get() {
		return value;
	}
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
	private TimeStamped timeStamp = new TimeStampedImp();
	private SerialNumbered serialNumber = new SerialNumberedImp();

	public long getStamp() {
		return timeStamp.getStamp();
	}

	public long getSerialNumber() {
		return serialNumber.getSerialNumber();
	}
}

public class Mixins {
	public static void main(String[] args) {
		Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
		mixin1.set("test string 1");
		mixin2.set("test string 2");
		System.out.println(mixin1.get() + " " + mixin1.getStamp() + " " + mixin1.getSerialNumber());
		System.out.println(mixin2.get() + " " + mixin2.getStamp() + " " + mixin2.getSerialNumber());
	}
} /*
	 * Output: (Sample) test string 1 1132437151359 1 test string 2 1132437151359 2
	 */// :~
