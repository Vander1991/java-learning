package szu.vander.string.stringbuilder;

/**
 * 
* @author      : Vander
* @date        : 2018-11-23
* @description : String的“+”与“+=”是java中仅有的两个重载过的操作符，Java不允许程序员重载任何操作符
* 				String对象是不可变的，因为它具有只读特性 ，不可变性会带来一定的效率问题
 */
public class Concatenation {
	public static void main(String[] args) {
		String mango = "mango";
		String s = "abc" + mango + "def" + 47;
		System.out.println(s);
	}
}
