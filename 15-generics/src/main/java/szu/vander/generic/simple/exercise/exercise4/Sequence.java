package szu.vander.generic.simple.exercise.exercise4;

// Holds a sequence of Objects.
/**
 * 
* @author      : Vander
* @date        : 2018-11-14
* @description ：  内部类可以访问其外围对象的所有成员；内部类还拥有其外围类的所有元素的访问权
* 			 内部类自动拥有其外围类所有成员的访问权，怎么做到？
* 				当某个外围类的对象创建了一个内部类对象时，此内部类对象必定会秘密捕获一个指向那个外围类对象的引用。然后，
* 				在你访问外围类的成员时，就是用那个引用来选择外围类的成员。注意，内部类只有在与其外围类的对象相关联的情况下
* 				才能被创建（内部类是非static类时）
* 			此处实现了迭代器模式，迭代器的实现以内部类的形式完成，使得设计更优雅
 */			
interface Selector {
	boolean end();

	Object current();

	void next();
}

public class Sequence<T> {
	private Object[] items;
	private int next = 0;

	public Sequence(int size) {
		items = new Object[size];
	}

	public void add(T x) {
		if (next < items.length)
			items[next++] = x;
	}

	private class SequenceSelector implements Selector {
		private int i = 0;

		public boolean end() {
			return i == items.length;
		}

		public Object current() {
			return items[i];
		}

		public void next() {
			if (i < items.length)
				i++;
		}
	}

	public Selector selector() {
		return new SequenceSelector();
	}

}
