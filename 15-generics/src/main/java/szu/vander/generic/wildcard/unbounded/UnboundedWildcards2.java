package szu.vander.generic.wildcard.unbounded;

//: generics/UnboundedWildcards2.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-14
* @description : 这里展示了无界通配符的一个重要应用，当你在处理多个泛型参数时，有时允许一个参数可以是任何类型，同时为其他参数确定某种
* 				特定类型的这种能力会显得很重要
 */
public class UnboundedWildcards2 {
	static Map map1;
	static Map<?, ?> map2;
	static Map<String, ?> map3;

	static void assign1(Map map) {
		map1 = map;
	}

	static void assign2(Map<?, ?> map) {
		map2 = map;
	}

	static void assign3(Map<String, ?> map) {
		map3 = map;
	}

	public static void main(String[] args) {
		assign1(new HashMap());
		assign2(new HashMap());
		// assign3(new HashMap()); // Warning:
		// Unchecked conversion. Found: HashMap
		// Required: Map<String,?>
		assign1(new HashMap<String, Integer>());
		assign2(new HashMap<String, Integer>());
		assign3(new HashMap<String, Integer>());
	}
} /// :~
