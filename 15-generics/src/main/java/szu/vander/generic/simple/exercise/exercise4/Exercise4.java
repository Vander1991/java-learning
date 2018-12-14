package szu.vander.generic.simple.exercise.exercise4;

/**
* @author      : Vander
* @date        : 2018-12-10
* @description ： 泛型化 innerclasses/Sequence.java类
*/
public class Exercise4 {
	
	public static void main(String[] args) {
		Sequence<String> sequence = new Sequence<String>(10);
		for (int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
	
}
