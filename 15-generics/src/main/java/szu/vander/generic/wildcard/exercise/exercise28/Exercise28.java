package szu.vander.generic.wildcard.exercise.exercise28;

import szu.vander.pet.Cat;
import szu.vander.pet.Dog;
import szu.vander.pet.Pet;

/**
* @author      : Vander
* @date        : 2018-12-14
* @description ：  创建一个泛型类Generic1<T>，它只有一个方法，将接受一个T类型的参数。创建第二个泛型类Generic2<T>，它也只有一个
* 				方法，将返回类型T的参数。编写一个泛型方法，它具有一个调用第一个泛型类的方法的逆变参数。编写第二个泛型方法，它具有一个调用
* 				第二个泛型的方法的协变参数。使用pets类库类进行测试
*/

class Generic1<T> {
	
	private T t;
	
	void add(T t) {
		this.t = t;
		System.out.println(this.t);
	}
	
}

class Generic2<T> {
	
	private T t;
	
	public Generic2(T t) {
		this.t = t;
	}
	
	T get() {
		return t;
	}
}

public class Exercise28 {

	static <T> void add(Generic1<? super T> g1, T item) {
		g1.add(item);
	}
	
	static <T> T get(Generic2<? extends T> g2) {
		return g2.get();
	}
	
	public static void main(String args[]) {
		Pet pet = new Pet();
		Pet cat = new Cat();
		Dog dog = new Dog();
		
		// 协变
		add(new Generic1<Pet>(), pet);
		add(new Generic1<Pet>(), dog);
		add(new Generic1<Pet>(), cat);
		
		// 逆变
		System.out.println(get(new Generic2<Pet>(new Cat())));
		System.out.println(get(new Generic2<Pet>(new Pet())));
		
	}
	
}
