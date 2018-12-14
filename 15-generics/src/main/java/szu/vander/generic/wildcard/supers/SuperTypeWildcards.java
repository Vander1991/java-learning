package szu.vander.generic.wildcard.supers;

//: generics/SuperTypeWildcards.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-14
* @description : 超类型边界放松了再可以向方法传递的参数上所做的限制
 */
class Fruit {
	
}

class Apple extends Fruit{
	
}

class Jonathan extends Apple {
	
}

public class SuperTypeWildcards {
	static void writeTo(List<? super Apple> apples) {
		apples.add(new Apple());
		apples.add(new Jonathan());
//		apples.add(new Fruit()); // Error
	}
} /// :~
