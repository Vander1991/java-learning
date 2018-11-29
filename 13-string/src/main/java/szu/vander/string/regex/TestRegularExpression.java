package szu.vander.string.regex;

import static szu.vander.util.Print.*;

//: strings/TestRegularExpression.java
// Allows you to easily try out regular expressions.
// {Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
* @author      : Vander
* @date        : 2018-11-28
* @description : 先使用Pattern.compile()编译你的正则表达式，它会根据你的String类型的正则表达式生成一个Pattern对象
* 				接着将想要检索的字符串传入Pattern对象的matcher方法，matcher方法会生成一个Matcher对象，它有很多功能
* 				例如：
* 					使用replaceAll将所有匹配部分替换成你传入的参数。
* 					
 */
public class TestRegularExpression {
	public static void main(String[] args) {
		if (args.length < 2) {
			print("Usage:\njava TestRegularExpression " + "characterSequence regularExpression+");
			System.exit(0);
		}
		print("Input: \"" + args[0] + "\"");
		for (String arg : args) {
			print("Regular expression: \"" + arg + "\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			while (m.find()) {
				print("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
			}
		}
	}
} /*
	 * Output: Input: "abcabcabcdefabc" Regular expression: "abcabcabcdefabc" Match
	 * "abcabcabcdefabc" at positions 0-14 Regular expression: "abc+" Match "abc" at
	 * positions 0-2 Match "abc" at positions 3-5 Match "abc" at positions 6-8 Match
	 * "abc" at positions 12-14 Regular expression: "(abc)+" Match "abcabcabc" at
	 * positions 0-8 Match "abc" at positions 12-14 Regular expression: "(abc){2,}"
	 * Match "abcabcabc" at positions 0-8
	 */// :~
