package szu.vander.generic.wildcard.extend;

//: generics/CompilerIntelligence.java
import java.util.Arrays;
import java.util.List;

/**
 * 
* @author      : Vander
* @date        : 2018-12-14
* @description : 编译器并没有那么聪明，尽管add()将接受一个具有泛型参数类型的参数，但是contains和indexOf()将接受
* 				Object类型的参数。当你指定一个ArrayList<? extends Fruit>时，add()参数变为 "? extends
* 				Fruit"。编译器并不了解这里需要的是Fruit的哪个子类型，因此它不会接受任何类型的Fruit，如果先将Apple向上
* 				转型为Fruit也于事无补——编译器将直接拒绝参数列表中涉及通配符的方法（例如add()）的调用
* 				 在使用contains()和indexof()时，参数类型是Object，因此不涉及任何通配符，编译器允许调用，这意味着
* 				将由泛型类的设计者来决定哪些调用时“安全的”，并使用Object类型作为参数类型。
* 				  为了在类型中使用通配符的情况下禁止这类调用，我们需要在参数列表中使用类型参数
 */
public class CompilerIntelligence {
	public static void main(String[] args) {
		List<? extends Fruit> flist = Arrays.asList(new Apple());
		Apple a = (Apple) flist.get(0); // No warning
		flist.contains(new Apple()); // Argument is 'Object'
		flist.indexOf(new Apple()); // Argument is 'Object'
	}
} /// :~
