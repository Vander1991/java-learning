package szu.vander.typeinfo.interfaceandtypeinfo.exercise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
* @author      : Vander
* @date        : 2018-12-09
* @description ： 这里使用c.getMethod是不行的
*/
public class Exercise25 {

	private static void callMethod(Class<?> c, String methodName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {
		Method method = c.getDeclaredMethod(methodName);
		method.setAccessible(true);
		method.invoke(c.newInstance());
	}
	
	public static void main(String args[]) {
		try {
			Class<?> c = Class.forName("szu.vander.typeinfo.interfaceandtypeinfo.exercise.exercise25.Test");
			callMethod(c, "testMethod1");
			callMethod(c, "testMethod2");
			callMethod(c, "testMethod3");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
}
