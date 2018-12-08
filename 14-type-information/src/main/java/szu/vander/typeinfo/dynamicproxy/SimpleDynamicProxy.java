package szu.vander.typeinfo.dynamicproxy;

import java.lang.reflect.*;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-08
 * @description: Java的动态代理比代理的思想更进一步，因为它可以动态地创建代理并动态地处理所代理方法的调用。
 * 				在动态代理商所做的所有调用都会被重定向到单一的调用处理器上，它的工作是揭示调用的类型并确定对应
 * 				的对策。
 * 				  通过调用静态方法Proxy.newProxyInstance()创建动态代理，这个方法需要得到一个类加载器
 * 				（通常从已经被加载的对象中获取该其类加载器），一个你希望该代理实现的接口列表（不是类或抽象类），
 * 				以及InvocationHandler接口的一个实现。动态代理可以将所有调用重定向到调用处理器，因此通常
 * 				调用处理器的构造器传递给一个“实际”对象的引用，从而使得调用处理器在执行其中介任务时，可以将请求转发
 * 				
 */

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy: " + proxy.getClass() + ", \nmethod: " + method + ", \nargs: " + args);
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
