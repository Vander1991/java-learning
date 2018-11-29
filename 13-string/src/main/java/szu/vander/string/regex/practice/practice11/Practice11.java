package szu.vander.string.regex.practice.practice11;
/**
* @author      : Vander
* @date        : 2018-11-28
* @description ： 
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
* @author      : Vander
* @date        : 2018-11-29
* @description : ?i是匹配不区分大小写
* 				 s?匹配0个或1个s
* 				 s*匹配0个或n个s
* 				 s+匹配1个或n个s
* 				 s{4}匹配连续的4个s
* 				 s{1-3}匹配0-3个s
* 				 这句话匹配的是以aeiou开头的单词（两个字母以上再匹配一个aeiou），最后以词的边界来匹配
 */
public class Practice11 {

	public final static String STR = "Iba Arline ate eight apples and one orange while";
	
	public final static String REGEX = "(?i)((^[aeiou])|(\\s[aeiou]))\\w+?[aeiou]\\b";
	
	public static void testRegex(final String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(STR);
		System.out.println("Regex:" + regex);
		while(matcher.find()) {
			System.out.println("match \"" + matcher.group() + "\" at " + matcher.start()
			+ "-" + (matcher.end()));
		}
	}
	
	public static void main(String args[]) {
		testRegex(REGEX);
	}
	
}
