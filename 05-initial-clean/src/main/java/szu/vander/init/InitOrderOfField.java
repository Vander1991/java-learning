package szu.vander.init;
/**
* @author      : Vander
* @date        : 2018-11-01
* @description ： 类中变量定义的先后顺序决定了初始化的顺序，而且变量初始化之后才调构造函数
*/
public class InitOrderOfField {

	public static void main(String args[]) {
		new House().f();
	}
	
}

class Window{
	Window(int marker){
		System.out.println("Window(" + marker + ")");
	}
}

class House {
	Window w1 = new Window(1);
	House(){
		System.out.println("House()");
		w3 = new Window(3);
	}
	Window w2 = new Window(2);
	void f() {
		System.out.println("f()");
	}
	Window w3 = new Window(3);
}