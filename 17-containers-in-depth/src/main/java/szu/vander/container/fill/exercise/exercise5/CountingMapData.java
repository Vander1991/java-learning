//: net/mindview/util/CountingMapData.java
// Unlimited-length Map containing sample data.
package szu.vander.container.fill.exercise.exercise5;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author : Vander
 * @date : 2019-01-13
 * @description: 修改此类，通过添加像Countries.java中那样的定制EntrySet类，来实现享元。
 */
public class CountingMapData {

	private static String[] DATA = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

	// Use AbstractMap by implementing entrySet()
	private static class FlyweightMap extends AbstractMap<Integer, String> {
		private static class Entry implements Map.Entry<Integer, String> {

			int index;

			Entry(int index) {
				this.index = index;
			}

			public boolean equals(Object o) {
				return Integer.valueOf(index).equals(o);
			}

			public Integer getKey() {
				return index;
			}

			public String getValue() {
				return DATA[index > DATA.length - 1  ? index % DATA.length : index] + (index % DATA.length);
			}

			public String setValue(String value) {
				throw new UnsupportedOperationException();
			}

			public int hashCode() {
				return Integer.valueOf(index).hashCode();
			}
		}

		// Use AbstractSet by implementing size() & iterator()
		static class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {

			private int size;
			
			public EntrySet(int size) {
				this.size = size;
			}
			
			@Override
			public int size() {
				return size;
			}
			
			private class Iter implements Iterator<Map.Entry<Integer, String>> {
				// Only one Entry object per Iterator:
				private Entry entry = new Entry(-1);

				public boolean hasNext() {
					return entry.index < size - 1;
				}

				public Map.Entry<Integer, String> next() {
					entry.index++;
					return entry;
				}

				public void remove() {
					throw new UnsupportedOperationException();
				}
			}

			public Iterator<Map.Entry<Integer, String>> iterator() {
				return new Iter();
			}

		}

		private static Set<Map.Entry<Integer, String>> entries = new EntrySet(DATA.length);

		public Set<Map.Entry<Integer, String>> entrySet() {
			return entries;
		}

	}

	// Create a partial map of 'size' countries:
	static Map<Integer, String> select(final int size) {
		return new FlyweightMap() {
			public Set<Map.Entry<Integer, String>> entrySet() {
				return new EntrySet(size);
			}
		};
	}

	static Map<Integer, String> map = new FlyweightMap();

	public static Map<Integer, String> chars() {
		return map; // The entire map
	}

	public static Map<Integer, String> chars(int size) {
		return select(size); // A partial map
	}

	public static void main(String[] args) {
		System.out.println(chars(100));
	}

}