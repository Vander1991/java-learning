package szu.vander.string.regex;

//: strings/Resetting.java
import java.util.regex.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-29
* @description : 使用不带参数的reset可以将Matcher对象重新设置到当前字符序列的起始位置
 */
public class Resetting {
	public static void main(String[] args) throws Exception {
		Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
		while (m.find()) {
			System.out.print(m.group() + " ");
		}
		System.out.println();
		m.reset("fix the rig with rags");
		while (m.find()) {
			System.out.print(m.group() + " ");
		}
	}
}