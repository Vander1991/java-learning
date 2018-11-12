package szu.vander.interfaces.decoupling;

import static szu.vander.util.Printer.print;

import java.util.Arrays;

/**
 * 
* @author      : Vander
* @date        : 2018-11-12
* @description ：  Apply.process()方法可以接受任何类型的Processor，并将其应用到一个Object对象上
* 				创建一个能够根据所传递的参数对象的不同而具有不同行为的方法，称为策略设计模式。这类方法包含所要执行的算法中
* 				固定不变的部分，而“策略”包含变化的部分。策略就是传递进去的参数对象，它包含要执行的代码。
* 				这里Processor对象就是一个策略
 */
class Processor {
	public String name() {
		return getClass().getSimpleName();
	}

	Object process(Object input) {
		return input;
	}
}

class Upcase extends Processor {
	// Covariant return-协变返回
	String process(Object input) { 
		return ((String) input).toUpperCase();
	}
}

class Downcase extends Processor {
	String process(Object input) {
		return ((String) input).toLowerCase();
	}
}

class Splitter extends Processor {
	String process(Object input) {
		// The split() argument divides a String into pieces:
		return Arrays.toString(((String) input).split(" "));
	}
}

public class Apply {
	public static void process(Processor p, Object s) {
		print("Using Processor " + p.name());
		//p.process处理有协变转换
		print(p.process(s));
	}

	public static String s = "Disagreement with beliefs is by definition incorrect";

	public static void main(String[] args) {
		process(new Upcase(), s);
		process(new Downcase(), s);
		process(new Splitter(), s);
	}
} /*
	 * Output: Using Processor Upcase DISAGREEMENT WITH BELIEFS IS BY DEFINITION
	 * INCORRECT Using Processor Downcase disagreement with beliefs is by definition
	 * incorrect Using Processor Splitter [Disagreement, with, beliefs, is, by,
	 * definition, incorrect]
	 */// :~
