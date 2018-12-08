package szu.vander.typeinfo.dynamicproxy;

//: typeinfo/SimpleProxyDemo.java
import static szu.vander.util.Print.print;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-08
 * @description: 代理在这里有点类似于适配器，将真正的对象包裹进来，然后需要调用的时候，再调用真正的对象干活
 * 				如果你希望跟踪对RealObject中的方法的调用，或者希望度量这些调用的开销，那么你应该怎么做
 * 				呢？这些代码肯定是你不希望将其并入到应用中的代码，因此代理是的你可以容易地添加或者移除它们
 */
interface Interface {
	void doSomething();

	void somethingElse(String arg);
}

class RealObject implements Interface {
	public void doSomething() {
		print("\tRealObject doSomething");
	}

	public void somethingElse(String arg) {
		print("\tRealObject somethingElse " + arg);
	}
}

class SimpleProxy implements Interface {
	private Interface proxied;

	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}

	public void doSomething() {
		print("SimpleProxy doSomething");
		proxied.doSomething();
	}

	public void somethingElse(String arg) {
		print("SimpleProxy somethingElse " + arg);
		proxied.somethingElse(arg);
	}
}

class SimpleProxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
} /*
	 * Output: doSomething somethingElse bonobo SimpleProxy doSomething doSomething
	 * SimpleProxy somethingElse bonobo somethingElse bonobo
	 */// :~
