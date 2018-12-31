package szu.vander.generic.mixin;

import java.util.*;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-30
 * @description: 使用装饰器所产生的对象类型是最后被装饰的类型。也就是说，尽管可以添加多个层，但是最后一层才是实际的类型，因此只有最后一层的方法是
 * 				可见的，而混型的类型是所有被混合到一起的类型。因此对于装饰器来说，其明显的缺陷是它只能有效地工作于装饰中的一层（最后一层），而
 * 				混型方法显然会自然一些，因此装饰器只是对由混型提出的问题的一种局限的解决方案
 */
class Basic1 {
	private String value;

	public void set(String val) {
		value = val;
	}

	public String get() {
		return value;
	}
}

class Decorator extends Basic1 {
	protected Basic1 basic;

	public Decorator(Basic1 basic) {
		this.basic = basic;
	}

	public void set(String val) {
		basic.set(val);
	}

	public String get() {
		return basic.get();
	}
}

class TimeStamped1 extends Decorator {
	private final long timeStamp;

	public TimeStamped1(Basic1 basic) {
		super(basic);
		timeStamp = new Date().getTime();
	}

	public long getStamp() {
		return timeStamp;
	}
}

class SerialNumbered1 extends Decorator {
	private static long counter = 1;
	private final long serialNumber = counter++;

	public SerialNumbered1(Basic1 basic) {
		super(basic);
	}

	public long getSerialNumber() {
		return serialNumber;
	}
}

public class Decoration {
	public static void main(String[] args) {
		TimeStamped1 t = new TimeStamped1(new Basic1());
		TimeStamped1 t2 = new TimeStamped1(new SerialNumbered1(new Basic1()));
		// ! t2.getSerialNumber(); // Not available
		SerialNumbered1 s = new SerialNumbered1(new Basic1());
		SerialNumbered1 s2 = new SerialNumbered1(new TimeStamped1(new Basic1()));
		// ! s2.getStamp(); // Not available
	}
} /// :~
