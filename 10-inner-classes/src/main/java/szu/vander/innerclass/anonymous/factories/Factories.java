package szu.vander.innerclass.anonymous.factories;

//: innerclasses/Factories.java
import static szu.vander.util.Printer.print;

/**
 * 
* @author      : Vander
* @date        : 2018-11-15
* @description ：  使用匿名内部类创建的工厂方法模式
 */
interface Service {
	void method1();

	void method2();
}

interface ServiceFactory {
	Service getService();
}

class ServiceImpl1 implements Service {
	private ServiceImpl1() {
	}

	public void method1() {
		print("ServiceImpl1 method1");
	}

	public void method2() {
		print("ServiceImpl1 method2");
	}

	public static ServiceFactory factory = new ServiceFactory() {
		public Service getService() {
			return new ServiceImpl1();
		}
	};
}

class ServiceImpl2 implements Service {
	private ServiceImpl2() {
	}

	public void method1() {
		print("ServiceImpl2 method1");
	}

	public void method2() {
		print("ServiceImpl2 method2");
	}

	public static ServiceFactory factory = new ServiceFactory() {
		public Service getService() {
			return new ServiceImpl2();
		}
	};
}

public class Factories {
	public static void serviceConsumer(ServiceFactory fact) {
		Service s = fact.getService();
		s.method1();
		s.method2();
	}

	public static void main(String[] args) {
		serviceConsumer(ServiceImpl1.factory);
		// Implementations are completely interchangeable:
		serviceConsumer(ServiceImpl2.factory);
	}
} /*
	 * Output: Implementation1 method1 Implementation1 method2 Implementation2
	 * method1 Implementation2 method2
	 */// :~
