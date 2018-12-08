package szu.vander.typeinfo.dynamicproxy.exercise.exercise23;

import static szu.vander.util.Print.print;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-08
 * @description: 这样会进入无限循环调用中，最后导致StackOverflowError，我们调用toString方法来打印代理对象，
 * 				然而我们会重定向去调用接口和代理以及继承于Object对象的方法
 * 				 效果就是一个处在System.out.println("proxy: " + proxy);
 * 				
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

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy: " + proxy);
		if (args != null) {
			for (Object arg : args) {
				System.out.println( "\targs: " + arg);
			}
		}
		return method.invoke(proxied, args);
	}
}

class SimpleDynamicProxy {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		RealObject real = new RealObject();
//		consumer(real);
		// Insert a proxy and call again:
		Interface proxy = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(),
				new Class[] { Interface.class }, 
				new DynamicProxyHandler(real));
		consumer(proxy);
	}
} /*
	 * Output: (95% match) doSomething somethingElse bonobo proxy: class $Proxy0,
	 * method: public abstract void Interface.doSomething(), args: null doSomething
	 **** proxy: class $Proxy0, method: public abstract void
	 * Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@42e816
	 * bonobo somethingElse bonobo
	 */// :~
