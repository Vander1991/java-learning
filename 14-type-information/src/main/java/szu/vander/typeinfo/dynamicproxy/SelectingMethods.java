package szu.vander.typeinfo.dynamicproxy;

import static szu.vander.util.Print.*;

//: typeinfo/SelectingMethods.java
// Looking for particular methods in a dynamic proxy.
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-08
 * @description: invoke()方法中传递进来了代理对象，以防你需要区分请求的来源。
 * 				通常你会执行被代理的操作，然后使用Method.invoke()将请求转发给被代理对象，并传入必需的参数。
 * 				这初看起来可能有些受限，就像你只能执行泛化操作一样。但是，你可以通过传递其他参数来过滤方法的调用
 */
class MethodSelector implements InvocationHandler {
	private Object proxied;

	public MethodSelector(Object proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().equals("interesting")) {
			print("Proxy detected the interesting method");
		}
		return method.invoke(proxied, args);
	}
}

interface SomeMethods {
	void boring1();

	void boring2();

	void interesting(String arg);

	void boring3();
}

class Implementation implements SomeMethods {
	public void boring1() {
		print("boring1");
	}

	public void boring2() {
		print("boring2");
	}

	public void interesting(String arg) {
		print("interesting " + arg);
	}

	public void boring3() {
		print("boring3");
	}
}

class SelectingMethods {
	public static void main(String[] args) {
		SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
				SomeMethods.class.getClassLoader(),
				new Class[] { SomeMethods.class }, 
				new MethodSelector(new Implementation()));
		proxy.boring1();
		proxy.boring2();
		proxy.interesting("bonobo");
		proxy.boring3();
	}
} /*
	 * Output: boring1 boring2 Proxy detected the interesting method interesting
	 * bonobo boring3
	 */// :~
