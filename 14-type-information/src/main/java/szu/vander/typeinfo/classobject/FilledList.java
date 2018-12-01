package szu.vander.typeinfo.classobject;

//: typeinfo/FilledList.java
import java.util.*;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-01
 * @description: 使用类引用和泛型的实例
 * 				在这里有一个有趣的地方，就是在create方法中使用newInstance方法产生的是一个确切的CountedInteger对象，而不是基本的Object对象
 */
class CountedInteger {
	private static long counter;
	private final long id = counter++;

	public String toString() {
		return Long.toString(id);
	}
}

public class FilledList<T> {
	private Class<T> type;

	public FilledList(Class<T> type) {
		this.type = type;
	}

	public List<T> create(int nElements) {
		List<T> result = new ArrayList<T>();
		try {
			for (int i = 0; i < nElements; i++) {
				result.add(type.newInstance());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	public static void main(String[] args) {
		FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
		System.out.println(fl.create(15));
	}
} /*
	 * Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
	 */// :~
