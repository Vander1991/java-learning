package szu.vander.string.regex;

import static szu.vander.util.Print.print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import szu.vander.util.TextFile;

/*! Here's a block     of text to use as input to
  the regular expression matcher. Note that we'll
  first extract the block of text by looking for
  the special delimiters, then process the
  extracted block. !*/

/**
 * 
 * @author : Vander
 * @date : 2018-11-29
 * @description : s.replaceAll(" {2,}", " ")是替换两个或两个以上空格的地方为一个空格
 *              s.replaceAll("(?m)^ +", "")是删除每行所有的空格
 *              replaceFirst()只对找到的第一个匹配的进行替换
 *              如果想对这些替换字符串进行某些特殊处理，这两个方法是无法胜任的，因为replace方法都只能直接替换成字符创，
 *              要想对替换字符串再处理就使用appendReplacement()方法
 * 				    此例子中先构造了sbuf用来保存最终结果，然后用group()选择一个组，并对其进行处理，将正则表达式找到的
 * 				元音字母转成大写字母。一般情况下，你应该遍历执行所有的替换操作，然后再调用appendTail()方法，但是如
 * 				果你想模拟replaceFirst()(或替换n次)的行为，那就只需执行一次替换
 * 				然后调用appendTail()方法，将剩余未处理的部分存入sbuf即可
 */
public class TheReplacements {

	public static void testAppendReplace() {
		Pattern p = Pattern.compile("cat");
		Matcher m = p.matcher("one cat two cats in the yard");
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "dog");
		}
		m.appendTail(sb);
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		String s = TextFile.read("src/main/java/szu/vander/string/regex/TheReplacements.java");
		// Match the specially commented block of text above:
		Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
		if (mInput.find()) {
			s = mInput.group(1); // Captured by parentheses
		}
		// Replace two or more spaces with a single space:
		s = s.replaceAll(" {2,}", " ");
		// Replace one or more spaces at the beginning of each
		// line with no spaces. Must enable MULTILINE mode:
		s = s.replaceAll("(?m)^ +", "");
		print(s);
		s = s.replaceFirst("[aeiou]", "(VOWEL1)");
		StringBuffer sbuf = new StringBuffer();
		Pattern p = Pattern.compile("[aeiou]");
		Matcher m = p.matcher(s);
		// Process the find information as you
		// perform the replacements:
		while (m.find()) {
			m.appendReplacement(sbuf, m.group().toUpperCase());
		}
		// Put in the remainder of the text:
		m.appendTail(sbuf);
		print(sbuf);
	}
}
