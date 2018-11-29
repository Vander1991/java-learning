package szu.vander.string.regex;

import static szu.vander.util.Print.*;

import java.util.Arrays;
//: strings/SplitDemo.java
import java.util.regex.Pattern;

/**
 * 
* @author      : Vander
* @date        : 2018-11-29
* @description : 第二种形式可以限制将输入分割成字符串的数量
 */
public class SplitDemo {
	public static void main(String[] args) {
		String input = "This!!unusual use!!of exclamation!!points";
		print(Arrays.toString(Pattern.compile("!!").split(input)));
		// Only do the first three:
		print(Arrays.toString(Pattern.compile("!!").split(input, 3)));
	}
} /*
	 * Output: [This, unusual use, of exclamation, points] [This, unusual use, of
	 * exclamation!!points]
	 */// :~
