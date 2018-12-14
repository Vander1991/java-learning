package szu.vander.generic.erasurecompensate.exercise.exercise23;

//: generics/FactoryConstraint.java

/**
 * 
 * @author : Vander
 * @date : 2018-12-12
 * @description : 修改FactoryConstraint.java，使其能接收一个参数
 */
interface FactoryI<T> {
	T create(Object obj);
}

class Foo2<T> {
	private T x;

	public <F extends FactoryI<T>> Foo2(F factory, Object obj) {
		x = factory.create(obj);
	}

}

class IntegerFactory implements FactoryI<Integer> {
	public Integer create(Object o) {
		return new Integer((int)o);
	}

}

class Widget {
	
	private String name;
	
	public Widget(String name) {
		this.name = name;
	}
	
	public static class Factory implements FactoryI<Widget> {
		public Widget create(Object obj) {
			return new Widget((String)obj);
		}
	}
	
	public String toString() {
		return "Widget:" + name;
	}
	
}

public class FactoryConstraint {
	public static void main(String[] args) {
		new Foo2<Integer>(new IntegerFactory(), 10);
		new Foo2<Widget>(new Widget.Factory(), "widget1");
	}
}
