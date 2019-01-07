package szu.vander.array.createtestdata.createarrayfromgenerator;

import szu.vander.util.CollectionData;
import szu.vander.util.Generator;

public class Generated {
	// Fill an existing array:
	public static <T> T[] array(T[] a, Generator<T> gen) {
		return new CollectionData<T>(gen, a.length).toArray(a);
	}

	// Create a new array:
	// 使用反射动态创建具有恰当类型和数量的新数组，然后使用第一个方法相同的技术来填充该数组
	@SuppressWarnings("unchecked")
	public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
		T[] a = (T[]) java.lang.reflect.Array.newInstance(type, size);
		return new CollectionData<T>(gen, size).toArray(a);
	}
} /// :~
