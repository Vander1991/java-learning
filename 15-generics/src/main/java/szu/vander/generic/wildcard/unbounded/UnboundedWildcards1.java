package szu.vander.generic.wildcard.unbounded;

//: generics/UnboundedWildcards1.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-14
* @description : 无界通配符<?>看起来意味着“任何事物”，因此使用无界通配符好像等价于使用原生类型
 */
public class UnboundedWildcards1 {
	static List list1;
	static List<?> list2;
	static List<? extends Object> list3;

	static void assign1(List list) {
		list1 = list;
		list2 = list;
		// list3 = list; // Warning: unchecked conversion
		// Found: List, Required: List<? extends Object>
	}

	static void assign2(List<?> list) {
		list1 = list;
		list2 = list;
		list3 = list;
	}

	static void assign3(List<? extends Object> list) {
		list1 = list;
		list2 = list;
		list3 = list;
	}

	public static void main(String[] args) {
		assign1(new ArrayList());
		assign2(new ArrayList());
		// assign3(new ArrayList()); // Warning:
		// Unchecked conversion. Found: ArrayList
		// Required: List<? extends Object>
		assign1(new ArrayList<String>());
		assign2(new ArrayList<String>());
		assign3(new ArrayList<String>());
		// Both forms are acceptable as List<?>:
		List<?> wildList = new ArrayList();
		wildList = new ArrayList<String>();
		assign1(wildList);
		assign2(wildList);
		assign3(wildList);
	}
} /// :~
