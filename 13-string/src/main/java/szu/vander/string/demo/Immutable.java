package szu.vander.string.demo;

import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-23
* @description : 当把q传给upcase()方法时，实际传递的是引用的一个拷贝。其实，每当把String对象当做方法的参数时，都会复制一份引用，
* 				而该引用所指的对象其实一直待在单一的物理位置上，从未动过
* 				  参数是为方法提供信息的，而不是想让该方法改变自己的。
 */
public class Immutable {
	public static String upcase(String s) {
		return s.toUpperCase();
		// 方法结束后引用s就消失了，这个方法的返回值其实只是最终结果的引用
	}

	public static void main(String[] args) {
		String q = "howdy";
		print(q); // howdy
		String qq = upcase(q);
		print(qq); // HOWDY
		print(q); // howdy
	}
}


