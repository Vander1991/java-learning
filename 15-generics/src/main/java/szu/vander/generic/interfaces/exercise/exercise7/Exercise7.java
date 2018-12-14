package szu.vander.generic.interfaces.exercise.exercise7;

/**
* @author      : Vander
* @date        : 2018-12-10
* @description ：  使用组合代理继承，适配Fibonacci使其成为Iterator
*/
public class Exercise7 {
	
	public static void main(String[] args) {
		for (int i : new IterableFibonacci(18))
			System.out.print(i + " ");
	}
	
}
