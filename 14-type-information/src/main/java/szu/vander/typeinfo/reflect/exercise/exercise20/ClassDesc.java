package szu.vander.typeinfo.reflect.exercise.exercise20;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author : Vander Choi
* @date : 2018-12-08
* @description :
*/
public class ClassDesc {

	private static final String CONSTRUCTORS_REGEX = "\\w+\\.";
	
	public static void printClassDetail(String arg0) {
		try {
			Class<?> c = Class.forName(arg0);
			
			// constructors
			System.out.println("Constructors : ");
			Constructor<?>[] ctors = c.getConstructors();
			Pattern patter = Pattern.compile(CONSTRUCTORS_REGEX);
			Matcher matcher = null;
			for(Constructor<?> ctor : ctors) {
				matcher = patter.matcher(ctor.toString());
				System.out.println("\t" + matcher.replaceAll(""));
			}
			
			// fields
			System.out.println("fields : ");
			Field[] fields = c.getDeclaredFields();
			for(Field field : fields) {
				matcher = patter.matcher(field.toString());
				System.out.println("\t" + matcher.replaceAll(""));
			}
			
			// methods
			System.out.println("fields : ");
			Method[] methods = c.getMethods();
			for(Method method : methods) {
				matcher = patter.matcher(method.toString());
				System.out.println("\t" + matcher.replaceAll(""));
			}
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
