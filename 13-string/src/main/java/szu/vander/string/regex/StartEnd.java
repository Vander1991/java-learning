package szu.vander.string.regex;

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
public class StartEnd {
	public static String input = 
			"As long as there is injustice, whenever a\n"
			+ "Targathian baby cries out, wherever a distress\n" 
			+ "signal sounds among the stars ... We'll be there.\n"
			+ "This fine ship, and this fine crew ...\n" 
			+ "Never give up! Never surrender!";

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
			for (String regex : new String[] { "\\w*ere\\w*", "\\w*ever", "T\\w+", "Never.*?!" }) {
				examine(in, regex);
			}
		}
	}
} /*
	 * Output: input : As long as there is injustice, whenever a \w*ere\w* find()
	 * 'there' start = 11 end = 16 \w*ever find() 'whenever' start = 31 end = 39
	 * input : Targathian baby cries out, wherever a distress \w*ere\w* find()
	 * 'wherever' start = 27 end = 35 \w*ever find() 'wherever' start = 27 end = 35
	 * T\w+ find() 'Targathian' start = 0 end = 10 lookingAt() start = 0 end = 10
	 * input : signal sounds among the stars ... We'll be there. \w*ere\w* find()
	 * 'there' start = 43 end = 48 input : This fine ship, and this fine crew ...
	 * T\w+ find() 'This' start = 0 end = 4 lookingAt() start = 0 end = 4 input :
	 * Never give up! Never surrender! \w*ever find() 'Never' start = 0 end = 5
	 * find() 'Never' start = 15 end = 20 lookingAt() start = 0 end = 5 Never.*?!
	 * find() 'Never give up!' start = 0 end = 14 find() 'Never surrender!' start =
	 * 15 end = 31 lookingAt() start = 0 end = 14 matches() start = 0 end = 31
	 */// :~
