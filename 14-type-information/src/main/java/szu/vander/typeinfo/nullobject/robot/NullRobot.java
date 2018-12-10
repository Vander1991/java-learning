package szu.vander.typeinfo.nullobject.robot;

//: typeinfo/NullRobot.java
// Using a dynamic proxy to create a Null Object.
import java.lang.reflect.*;
import java.util.*;

import szu.vander.typeinfo.nullobject.Operation;
import szu.vander.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-09
* @description : 无论何时，如果需要一个空Robot对象，只需调用newNullRobot()，并传递需要代理的Robot的类型。代理会满足
* 				Robot和Null接口的需求，并提供它所代理的类型的确切名字
* 				 因为在调用处理器中所使用的proxied被代理类是NRobot()，所以调用方法的时候，调用的全是NRobot的方法
* 
 */

class NullRobotProxyHandler implements InvocationHandler {
	private String nullName;
	private Robot proxied = new NRobot();

	NullRobotProxyHandler(Class<? extends Robot> type) {
		nullName = type.getSimpleName() + " NullRobot";
	}

	private class NRobot implements Null, Robot {
		public String name() {
			return nullName;
		}

		public String model() {
			return nullName;
		}

		public List<Operation> operations() {
			return Collections.emptyList();
		}
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(proxied, args);
	}
}

public class NullRobot {
	public static Robot newNullRobot(Class<? extends Robot> type) {
		return (Robot) Proxy.newProxyInstance(
				Null.class.getClassLoader(), // 随便找一个已经被加载了的类的类加载器
				new Class[] { Null.class, Robot.class }, // 你希望它代理的接口列表
				new NullRobotProxyHandler(type)); // 具体的调用处理器
	}

	public static void main(String[] args) {
		Robot[] bots = { new SnowRemovalRobot("SnowBee"), newNullRobot(SnowRemovalRobot.class) };
		for (Robot bot : bots) {
			Robot.Test.test(bot);
		}
	}
} /*
	 * Output: Robot name: SnowBee Robot model: SnowBot Series 11 SnowBee can shovel
	 * snow SnowBee shoveling snow SnowBee can chip ice SnowBee chipping ice SnowBee
	 * can clear the roof SnowBee clearing roof [Null Robot] Robot name:
	 * SnowRemovalRobot NullRobot Robot model: SnowRemovalRobot NullRobot
	 */// :~
