//: net/mindview/util/CollectionData.java
// A Collection filled with data using a generator object.
package szu.vander.container.fill.collection;

import java.util.*;

import szu.vander.util.Generator;

/**
 * 
* @author      : Vander
* @date        : 2019-01-09
* @description ：此处将Generator适配到了Collection的构造器上，使用了适配器模式 
 */
public class CollectionData<T> extends ArrayList<T> {
	public CollectionData(Generator<T> gen, int quantity) {
		for (int i = 0; i < quantity; i++) {
			add(gen.next());
		}
	}

	// A generic convenience method:
	public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
		return new CollectionData<T>(gen, quantity);
	}
} /// :~
