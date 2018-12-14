package szu.vander.generic.simple.exercise.exercise5;

/**
* @author      : Vander
* @date        : 2018-12-10
* @description ： 修改LinkedStack.java的代码，证明内部类可以访问其外部类的类型参数
*/
public class Exercise5 {
	
	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<String>();
		for (String s : "Phasers on stun!".split(" ")) {
			lss.push(s);
		}
		String s;
		while ((s = lss.pop()) != null) {
			System.out.println(s);
		}
	}
	
}
