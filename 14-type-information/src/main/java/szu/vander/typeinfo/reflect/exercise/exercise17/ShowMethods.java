package szu.vander.typeinfo.reflect.exercise.exercise17;

import static szu.vander.util.Print.*;

//: typeinfo/ShowMethods.java
// Using reflection to show all the methods of a class,
// even if the methods are defined in the base class.
// {Args: ShowMethods}
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 
* @author      : Vander
* @date        : 2018-12-03
* @description : 修改正则表达式，去掉native和final关键字 
* 
 */
public class ShowMethods {
	private static String usage = "usage:\n" 
			+ "ShowMethods qualified.class.name\n"
			+ "To show all methods in class or:\n"
			+ "ShowMethods qualified.class.name word\n"
			+ "To search for methods involving 'word'";
	
	/** 此模式用replaceAll将多个w+.给替换掉    (\w	A word character: [a-zA-Z_0-9]) */
	private static Pattern p = Pattern.compile("\\w+\\.|native |final ");
	
	public static void showMethod(String[] args) {
		if (args.length < 1) {
			print(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			// args[0] = "szu.vander.typeinfo.reflect.exercise.exercise17.ShowMethods"
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			if (args.length == 1) {
				for (Method method : methods)
					print(p.matcher(method.toString()).replaceAll(""));
				for (Constructor ctor : ctors)
					print(p.matcher(ctor.toString()).replaceAll(""));
				lines = methods.length + ctors.length;
			} else {
				for (Method method : methods)
					if (method.toString().indexOf(args[1]) != -1) {
						print(p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				for (Constructor ctor : ctors)
					if (ctor.toString().indexOf(args[1]) != -1) {
						print(p.matcher(ctor.toString()).replaceAll(""));
						lines++;
					}
			}
		} catch (ClassNotFoundException e) {
			print("No such class: " + e);
		}
	}
} /*
 * Output: 	public static void main(String[]) 
 * 		   	public native int hashCode() 
 * 		   	public final native Class getClass()
 * 			public final void wait(long,int) throws InterruptedException
 * 			public final void wait() throws InterruptedException
 * 			public final native void wait(long) throws InterruptedException 
 * 			public boolean equals(Object) 
 * 			public String toString() 
 * 			public final native void notify()
 * 			public final native void notifyAll()
 * 			public ShowMethods()
 */// :~
