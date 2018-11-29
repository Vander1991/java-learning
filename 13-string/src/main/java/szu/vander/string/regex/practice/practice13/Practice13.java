package szu.vander.string.regex.practice.practice13;

import java.util.regex.*;
import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-29
* @description : 在匹配成功之后，start返回先匹配的起始位置的索引，end返回所匹配的最后的字符的索引加一的值
* 				find()可以在输入的任意位置定位正则表达式
* 				matches()只有在整个输入都匹配正则表达式时才会成功
* 				lookingAt()只要输入的第一部分匹配就会成功
 */
public class Practice13 {
	public static final String input = 
			"twas brillig, and the slithy toves\n" 
			+ "Did gyre and gimble in the wabe.\n"
			+ "All mimsy were the borogoves,\n" 
			+ "And the mome raths outgrabe.\n"
			+ "Beware the Jabberwock, my son,\n" 
			+ "The jaws that bite, the claws that catch.\n"
			+ "Beware the Jubjub bird, and shun\n" 
			+ "The frumious Bandersnatch.";

	private static class Display {
		private boolean regexPrinted = false;
		private String regex;

		Display(String regex) {
			this.regex = regex;
		}

		void display(String message) {
			if (!regexPrinted) {
				print(regex);
				regexPrinted = true;
			}
			print(message);
		}
	}

	static void examine(String s, String regex) {
		Display d = new Display(regex);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		while (m.find()) {
			d.display("find() '" + m.group() + "' start = " + m.start() + " end = " + m.end());
		}
		if (m.lookingAt()) {// No reset() necessary
			d.display("lookingAt() start = " + m.start() + " end = " + m.end());
		}
		if (m.matches()) {// No reset() necessary
			d.display("matches() start = " + m.start() + " end = " + m.end());
		}
	}

	public static void main(String[] args) {
		for (String in : input.split("\n")) {
			print("input : " + in);
			String regex = "Did|\\w+ogo\\w+|Beware.*?";
			examine(in, regex);
		}
	}
}
