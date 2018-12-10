package szu.vander.typeinfo.nullobject.staff;

//: typeinfo/Person.java
// A class with a Null Object.

import szu.vander.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-09
* @description : 空对象都是单例，因此将其作为静态final实例创建
* 				如果你想要修改一个NullPerson，只能用一个新的Person对象来替换它。
* 				注意，你可以选择使用instanceof来探测泛化的Null还是具体的NullPerson，
* 				但是由于使用了单例方式，所以你还可以只使用equals()甚至==来与Person.Null比较
 */
class Person {
	public final String first;
	public final String last;
	public final String address;

	// etc.
	public Person(String first, String last, String address) {
		this.first = first;
		this.last = last;
		this.address = address;
	}

	public String toString() {
		return "Person: " + first + " " + last + " " + address;
	}

	public static class NullPerson extends Person implements Null {
		private NullPerson() {
			super("None", "None", "None");
		}

		public String toString() {
			return "NullPerson";
		}
	}

	public static final Person NULL = new NullPerson();
}
