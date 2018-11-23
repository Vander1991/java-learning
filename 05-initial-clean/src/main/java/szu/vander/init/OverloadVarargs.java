package szu.vander.init;

/**
 * @author : Vander
 * @date : 2018-11-01
 * @description ：可变参数列表的原理实际上就是参数列表是一个数组，编译器将多个变量组成一个数组来处理了
 */
public class OverloadVarargs {

	static void f(Character... args) {
		System.out.print("first");
		for(char c : args) {
			System.out.print(" " + c);
		}
		System.out.println("");
	}
	
	static void f(Integer... args) {
		System.out.print("second");
		for(int i : args) {
			System.out.print(" " + i);
		}
		System.out.println("");
	}
	
	public static void main(String args[]) {
		f('a', 'b', 'c');
		f(1, 2, 3);
		//f();The method f(Character[]) is ambiguous for the type OverloadVarargs
	}

}
