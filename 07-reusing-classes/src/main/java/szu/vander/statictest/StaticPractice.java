package szu.vander.statictest;
/**
* @author : Vander Choi
* @date : 2018-11-11
* @description : 类加载动作只发生一次，类的第一个实体创建或者对static成员的访问都有可能引起加载
*/
public class StaticPractice {

	public static void main(String args[]) {
		//new A();
		A.a = 100;
	}
	
}

class A {
	
	static int a = print(10);
	
	static int print(int a) {
		System.out.println(a);
		return a;
	}
	
	static {
		System.out.println("static A");
	}
	
	A() {
		System.out.println("A()");
	}
	
}