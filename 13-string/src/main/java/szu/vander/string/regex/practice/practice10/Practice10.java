package szu.vander.string.regex.practice.practice10;
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
* @description : s?匹配0个或1个s
* 				 s*匹配0个或n个s
* 				 s+匹配1个或n个s
* 				 s{4}匹配连续的4个s
* 				 s{1-3}匹配0-3个s
 */
public class Practice10 {

	public final static String STR = "Java now has regular expressions";
	
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
		String[] regexs = {"^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s?", 
				"s*", "s+","s{4}", "s{1}", "s{1,3}"};
		for(String regex : regexs) {
			testRegex(regex);
		}
	}
	
}
