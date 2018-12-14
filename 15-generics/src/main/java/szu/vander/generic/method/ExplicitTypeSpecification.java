package szu.vander.generic.method;

//: generics/ExplicitTypeSpecification.java
import java.util.List;
import java.util.Map;

/**
 * 
* @author      : Vander
* @date        : 2018-12-11
* @description : 显式类型说明，不过这种语法很少使用
 */
public class ExplicitTypeSpecification {
	static void f(Map<Person, List<Pet>> petPeople) {
	}

	public static void main(String[] args) {
		f(New.<Person, List<Pet>>map());
	}
} /// :~
