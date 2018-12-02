//: net/mindview/util/TypeCounter.java
// Counts instances of a type family.
package szu.vander.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
* @author      : Vander
* @date        : 2018-12-02
* @description : count()方法获取其参数的Class，然后使用isAssignableFrom()来执行运行时的检查，
* 				以校验你传递的对象确实属于我们感兴趣的继承结构。countClass()首先对该类的确切类型计数，
* 				然后如果其超累可以赋值给baseType，countClass()将其超类上递归计数
* 
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {
	private Class<?> baseType;

	public TypeCounter(Class<?> baseType) {
		this.baseType = baseType;
	}

	public void count(Object obj) {
		Class<?> type = obj.getClass();
		if (!baseType.isAssignableFrom(type))
			throw new RuntimeException(obj + " incorrect type: " + type + ", should be type or subtype of " + baseType);
		countClass(type);
	}

	private void countClass(Class<?> type) {
		Integer quantity = get(type);
		put(type, quantity == null ? 1 : quantity + 1);
		Class<?> superClass = type.getSuperclass();
		if (superClass != null && baseType.isAssignableFrom(superClass)) {
			countClass(superClass);
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder("{");
		for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
			result.append(pair.getKey().getSimpleName());
			result.append("=");
			result.append(pair.getValue());
			result.append(", ");
		}
		result.delete(result.length() - 2, result.length());
		result.append("}");
		return result.toString();
	}
} /// :~
