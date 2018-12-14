package szu.vander.generic.method;

//: generics/LimitsOfInference.java
import java.util.List;
import java.util.Map;

/**
 * 
* @author      : Vander
* @date        : 2018-12-11
* @description : 类型推断只对赋值操作有效，其他时候并不起作用
* 				编译器认为使用泛型方法后，其返回值被赋给一个Object类型的变量
 */
class Person {
}

class Pet {
}

public class LimitsOfInference {
	static void f(Map<Person, List<? extends Pet>> petPeople) {
	}

	public static void main(String[] args) {
		// f(New.map()); // Does not compile
	}
} /// :~
