package szu.vander.string.regex;

import static szu.vander.util.Print.*;

//: strings/Finding.java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
* @author      : Vander
* @date        : 2018-11-29
* @description : find()能接受一个整数为参数，该证书表示字符串中字符的位置，并以其作为搜索的起点
 */
public class Finding {
	public static void main(String[] args) {
		Matcher m = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings");
		while (m.find()) {
			printnb(m.group() + " ");
		}
		print();
		int i = 0;
		while (m.find(i)) {
			printnb(m.group() + " ");
			i++;
		}
	}
} /*
	 * Output: Evening is full of the linnet s wings Evening vening ening ning ing
	 * ng g is is s full full ull ll l of of f the the he e linnet linnet innet nnet
	 * net et t s s wings wings ings ngs gs s
	 */// :~
