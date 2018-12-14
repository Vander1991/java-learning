package szu.vander.generic.erasedscrect;

//: generics/GenericHolder.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-12
* @description : 泛型的所有动作都发生在边界处-对传递进来的值进行额外的编译器检查，并插入对传递出去的值的转型
 */
public class GenericHolder<T> {
	private T obj;

	public void set(T obj) {
		this.obj = obj;
	}

	public T get() {
		return obj;
	}

	public static void main(String[] args) {
		GenericHolder<String> holder = new GenericHolder<String>();
		holder.set("Item");
		String s = holder.get();
	}
}
