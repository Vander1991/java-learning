package szu.vander.init;
/**
* @author      : Vander
* @date        : 2018-11-01
* @description ： 首先static的优先初始化，且初始化次数为1次，接着是普通变量，然后才是构造函数的调用
*/
public class InitOrderOfStaticField {

	public static void main(String args[]) {
		System.out.println("Create new Cupboard() in main");
		new Cupboard();
		System.out.println("Create new Cupboard() in main");
		new Cupboard();
		table.f2(1);
		cupboard.f3(1);
	}
	
	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();
	
}

class Bowl{
	
	public Bowl(int marker) {
		System.out.println("Bowl(" + marker + ")");
	}
	
	public void f1(int marker) {
		System.out.println("f1(" + marker + ")");
	}
	
}

class Table {
	
	static Bowl bowl1 = new Bowl(1);
	
	Table(){
		System.out.println("Table()");
		bowl2.f1(1);
	}
	
	public void f2(int marker) {
		System.out.println("f2(" + marker + ")");
	}
	
	static Bowl bowl2 = new Bowl(2);
	
}

class Cupboard {
	
	Bowl bowl3 = new Bowl(3);
	static Bowl bowl4 = new Bowl(4);
	
	Cupboard(){
		System.out.println("Cupboard()");
		bowl4.f1(2);
	}
	
	public void f3(int marker) {
		System.out.println("f3(" + marker + ")");
	}
	
	static Bowl bowl5 = new Bowl(5);
	
}

/**
 * 总结一下对象的创建过程，以Dog的类为例：
 * 		1、即使没有显示地使用static，构造器实际上也是一个静态方法，因此，当首次创建类型为Dog的对象时，Dog类的静态方法
 * 		、静态域首次被访问时，Java解释器必须查找类路径，去定位Dog.class文件。
 * 		2、然后载入Dog.class，有关静态初始化的所有动作都会执行，因此，静态初始化只在Class对象首次加载的时候进行一次
 * 		3、当用new Dog()创建对象时，首先将在堆上的Dog对象分配足够的存储空间
 * 		4、这块存储空间会被清0，这就自动地将Dog对象中的所有基本类型数据都设置成默认值
 * 		5、执行所有出现于字段定义处的初始化动作
 * 		6、执行构造器
 * 
 */

