package szu.vander.string.regex;

//: strings/Rudolph.java

/**
 * 
 * @author     : Vander
 * @date       : 2018-11-24
 * @description: "."表示任意字符，“.*”表示任意字符多个
 */
public class Rudolph {
	public static void main(String[] args) {
		for (String pattern : new String[] { "Rudolph", "[rR]udolph", "[rR][aeiou][a-z]ol.*", "R.*" })
			System.out.println("Rudolph".matches(pattern));
	}
} /*
	 * Output: true true true true
	 */// :~
