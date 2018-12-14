package szu.vander.generic.erasurecompensate.newt;

//: generics/InstantiateGenericType.java
import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-12
* @description : 为了解决new T()的问题，Java的解决方案是传入工厂对象那个，最便利的工厂对象就是Class对象，因此如果使用类型标签，
* 				你就可以用new Instance()来创建这个类型的新对象
* 				 这可以编译，但是会因ClassAsFactory<Integer>而失败，因为Integer没有任何默认的构造器，所以Sun并不建议使用
* 				这种方法，他们建议使用显式的工厂，并将限制其类型，使得只能接受实现了这个工厂的类
 */
class ClassAsFactory<T> {
	
	T x;

	public ClassAsFactory(Class<T> kind) {
		try {
			x = kind.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class Employee {
}

public class InstantiateGenericType {
	public static void main(String[] args) {
		ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
		print("ClassAsFactory<Employee> succeeded");
		try {
			ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
		} catch (Exception e) {
			print("ClassAsFactory<Integer> failed");
		}
	}
}