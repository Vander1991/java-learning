package szu.vander.container.optionaloperation;

//: containers/Unsupported.java
// Unsupported operations in Java containers.
import java.util.*;

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-13
 * @description: unmodifiableList方法修饰过的，不能set只能读取，也不能增加尺寸，这个方法将传入的容器包装到了一个代理中，当执行任何试图修改容器的操作，
 * 				这个代理就会抛出UnsupportedOperationException。
 * 				 Arrays.asList方法则返回尺寸固定的list
 */
public class Unsupported {
	static void test(String msg, List<String> list) {
		System.out.println("--- " + msg + " ---");
		Collection<String> c = list;
		Collection<String> subList = list.subList(1, 8);
		// Copy of the sublist:
		Collection<String> c2 = new ArrayList<String>(subList);
		try {
			c.retainAll(c2);
		} catch (Exception e) {
			System.out.println("retainAll(): " + e);
		}
		try {
			c.removeAll(c2);
		} catch (Exception e) {
			System.out.println("removeAll(): " + e);
		}
		try {
			c.clear();
		} catch (Exception e) {
			System.out.println("clear(): " + e);
		}
		try {
			c.add("X");
		} catch (Exception e) {
			System.out.println("add(): " + e);
		}
		try {
			c.addAll(c2);
		} catch (Exception e) {
			System.out.println("addAll(): " + e);
		}
		try {
			c.remove("C");
		} catch (Exception e) {
			System.out.println("remove(): " + e);
		}
		// The List.set() method modifies the value but
		// doesn't change the size of the data structure:
		try {
			list.set(0, "X");
		} catch (Exception e) {
			System.out.println("List.set(): " + e);
		}
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
		test("Modifiable Copy", new ArrayList<String>(list));
		test("Arrays.asList()", list);
		test("unmodifiableList()", Collections.unmodifiableList(new ArrayList<String>(list)));
	}
} /*
	 * Output: --- Modifiable Copy --- --- Arrays.asList() --- retainAll():
	 * java.lang.UnsupportedOperationException removeAll():
	 * java.lang.UnsupportedOperationException clear():
	 * java.lang.UnsupportedOperationException add():
	 * java.lang.UnsupportedOperationException addAll():
	 * java.lang.UnsupportedOperationException remove():
	 * java.lang.UnsupportedOperationException --- unmodifiableList() ---
	 * retainAll(): java.lang.UnsupportedOperationException removeAll():
	 * java.lang.UnsupportedOperationException clear():
	 * java.lang.UnsupportedOperationException add():
	 * java.lang.UnsupportedOperationException addAll():
	 * java.lang.UnsupportedOperationException remove():
	 * java.lang.UnsupportedOperationException List.set():
	 * java.lang.UnsupportedOperationException
	 */// :~
