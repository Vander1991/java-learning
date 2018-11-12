package szu.vander.polymorphism.field;

/**
 * 
* @author      : Vander
* @date        : 2018-11-12
* @description ：  只有普通的方法调用可以是多态的，直接访问某个域，这个访问将在编译器进行解析
* 				此例子中实际上Sub包括了两个field的域，一个是父类来的，一个是它自己的。
* 				虽然这个容易让人混淆，但是实际中会将所有field设置成private，不能直接访问它们，而且也不会让父类跟
* 				子类的field的名字一样。
 */
class Super {
	public int field = 0;

	public int getField() {
		return field;
	}
}

class Sub extends Super {
	public int field = 1;

	public int getField() {
		return field;
	}

	public int getSuperField() {
		return super.field;
	}
}

public class FieldAccess {
	public static void main(String[] args) {
		System.out.println("----new Sub() upcast Super----");
		Super sup = new Sub();
		System.out.println("sup.field = " + sup.field);
		System.out.println("sup.getField() = " + sup.getField());
		System.out.println("----new Sub() no upcast----");
		Sub sub = new Sub();
		System.out.println("sub.field = " + sub.field);
		System.out.println("sub.getField() = " + sub.getField());
		System.out.println("sub.getSuperField() = " + sub.getSuperField());
	}
}
