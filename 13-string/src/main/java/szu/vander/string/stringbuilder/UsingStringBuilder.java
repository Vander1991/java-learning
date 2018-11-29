package szu.vander.string.stringbuilder;

//: strings/UsingStringBuilder.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-23
* @description : 使用StringBuilder构建例子，在这里只能用.append一直拼接起来，但是如果你用append("a"+"c")，这样编译器就会另外创建
* 				StringBuilder对象处理括号内的字符串操作
 */
public class UsingStringBuilder {
	public static Random rand = new Random(47);

	public String toString() {
		StringBuilder result = new StringBuilder("[");
		for (int i = 0; i < 25; i++) {
			result.append(rand.nextInt(100));
			result.append(", ");
		}
		result.delete(result.length() - 2, result.length());
		result.append("]");
		return result.toString();
	}

	public static void main(String[] args) {
		UsingStringBuilder usb = new UsingStringBuilder();
		System.out.println(usb);
	}
}
