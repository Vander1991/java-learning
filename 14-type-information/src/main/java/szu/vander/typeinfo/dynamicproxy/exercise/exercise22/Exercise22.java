package szu.vander.typeinfo.dynamicproxy.exercise.exercise22;

import java.lang.reflect.Proxy;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-08
 * @description: 修改SimpleDynamicProxy.java，使其可以度量方法调用的次数 
 * 
 */
public class Exercise22 {

	public static void main(String[] args) {
		RealObject real = new RealObject();
		Interface proxy = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(),
				new Class[] { Interface.class }, 
				new DynamicProxyHandler(real));
		SimpleDynamicProxy.consumer(proxy);
		System.out.println();
	}

}
