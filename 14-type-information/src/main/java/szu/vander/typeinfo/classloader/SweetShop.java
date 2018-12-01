package szu.vander.typeinfo.classloader;

//: typeinfo/SweetShop.java
// Examination of the way the class loader works.
import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-30
* @description : 以下的三个class均有static方法，此方法会在该类第一次被加载时打印出对应的语句
* 				Class.forName("Gum")，这个方法是Class类（所有Class对象都属于这个类）的一个static成员
* 				Class对象就和其他对象一样我们可以获取并操作它的引用（这就是类加载器的工作），forName是取得Class对象
* 				引用的一种方法
 */
class Candy {
	static {
		print("Loading Candy");
	}
}

class Gum {
	static {
		print("Loading Gum");
	}
}

class Cookie {
	static {
		print("Loading Cookie");
	}
}

public class SweetShop {
	public static void main(String[] args) {
		print("inside main");
		new Candy();
		print("After creating Candy");
		try {
			Class.forName("szu.vander.typeinfo.classloader.Gum");
		} catch (ClassNotFoundException e) {
			print("Couldn't find Gum");
		}
		print("After Class.forName(\"Gum\")");
		new Cookie();
		print("After creating Cookie");
	}
} /*
	 * Output: inside main Loading Candy After creating Candy Loading Gum After
	 * Class.forName("Gum") Loading Cookie After creating Cookie
	 */// :~
