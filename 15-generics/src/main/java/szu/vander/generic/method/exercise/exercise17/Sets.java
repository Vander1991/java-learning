//: net/mindview/util/Sets.java
package szu.vander.generic.method.exercise.exercise17;

import java.util.*;

/**
 * 
 * @author : Vander
 * @date : 2018-12-11
 * @description :
 *              研究JDK文档中有关EnumSet的部分，你会看到它定义了clone()方法。然而在Sets.java中，你却不能复制Set接口中的
 *              引用。请试着修改Sets.java，使其不但能接受一般的Set接口，而且能直接接受EnumSet,并使用clone()而不是创建新的
 *              HashSet对象。
 */
class Sets2 {
	@SuppressWarnings("unchecked")
	protected static <T> Set<T> copy(Set<T> s) {
		if (s instanceof EnumSet) {
			return ((EnumSet) s).clone();
		}
		return new HashSet<T>(s);
	}

	public static <T> Set<T> union(Set<T> a, Set<T> b) {
		Set<T> result = copy(a);
		result.addAll(b);
		return result;
	}

	public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
		Set<T> result = copy(a);
		result.retainAll(b);
		return result;
	}

	public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
		Set<T> result = copy(superset);
		result.removeAll(subset);
		return result;
	}

	public static <T> Set<T> complement(Set<T> a, Set<T> b) {
		return difference(union(a, b), intersection(a, b));
	}
}
