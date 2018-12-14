package szu.vander.generic.erasurecompensate.array;

//: generics/ListOfGenerics.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-12
* @description : 不能创建泛型数组，一般的解决方案是在任何要创建泛型数组的地方使用ArrayList来代替
 */
public class ListOfGenerics<T> {
	private List<T> array = new ArrayList<T>();

	public void add(T item) {
		array.add(item);
	}

	public T get(int index) {
		return array.get(index);
	}
} /// :~
