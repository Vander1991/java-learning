package szu.vander.string.regex;

//: strings/ReFlags.java
import java.util.regex.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-29
* @description : 设置了不区分大小写且对每一行都进行匹配
 */
public class ReFlags {
	public static void main(String[] args) {
		String str = 
				"java has regex\n"
				+ "Java has regex\n"
				+ "JAVA has pretty good regular expressions\n"
				+ "Regular expressions are in Java";
		Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
		Matcher m = p.matcher(str);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}


