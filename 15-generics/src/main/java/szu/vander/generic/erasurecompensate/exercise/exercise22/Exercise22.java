package szu.vander.generic.erasurecompensate.exercise.exercise22;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author : Vander
 * @date : 2018-12-11
 * @description ： 使用标签和反射来创建一个方法，它将使用newInstance()的参数版本来创建某个类的对象，这个类拥有一个参数的构造器
 */
class Student {
	private final String studentId;

	public Student(String studentId) {
		this.studentId = studentId;
	}

	public String toString() {
		return "Student(" + studentId + ")";
	}
}

class ClassAsFactory<T> {
	Class<T> kind;
	
	public ClassAsFactory(Class<T> kind) {
		this.kind = kind;
	}
	
	public T create(Object[] parameters, Class<?>... parameterTypes) {
		try {
			Constructor<T> ctor = kind.getConstructor(parameterTypes);
			return ctor.newInstance(parameters);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

public class Exercise22 {

	public static void main(String args[]) {
		ClassAsFactory<Student> classAsFactory1 = new ClassAsFactory<Student>(Student.class);
		Student student = classAsFactory1.create(new Object[] { "0001" }, String.class);
		System.out.println(student);
		ClassAsFactory<Integer> classAsFactory2 = new ClassAsFactory<Integer>(Integer.class);
		int i = classAsFactory2.create(new Object[] {"10"}, String.class);
		int j = classAsFactory2.create(new Object[] {1000}, int.class);
		System.out.println("i=" + i + ", j=" + j);
	}
}
