package szu.vander.typeinfo.reflect.exercise.exercise19;

import static szu.vander.util.Print.print;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
* @author : Vander Choi
* @date : 2018-12-07
* @description : 修改ToyTest.java,使用反射机制，通过非默认构造器创建Toy对象
* 				这里要注意的是Class.getConstructors()方法拿到的都是Public的构造方法，然后使用Constructor.newInstance来创建
* 				Toy对象
*/
public class Exercise19 {

	public static void main(String args[]) {
		makeToy("szu.vander.typeinfo.reflect.exercise.exercise19.FancyToy", 10);
	}
	
	public static void makeToy(String className, int i) {
		Class<?> c = null;
		Toy toy = null;
		try {
			c = Class.forName(className);
			Constructor<?>[] ctors = c.getConstructors();
			for( Constructor<?> ctor: c.getConstructors()) {
				Class<?>[] params = ctor.getParameterTypes();
				if(params.length == 1 && params[0].equals(int.class)) {
					toy = (Toy)ctor.newInstance(new Object[] {Integer.valueOf(i)});
				}
			}
			System.out.println(toy);
		} catch (ClassNotFoundException e) {
			print("Can't find FancyToy");
			System.exit(1);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
