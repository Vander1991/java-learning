package szu.vander.string.regex.practices.practice10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author : Vander Choi
* @date : 2018-11-24
* @description :
*/
public class Practice10 {

	private final static String SENTENSE = "Java now has regular expressions";
	
	public static void match(String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(SENTENSE);
		System.out.println("Regex : " + regex);
		while(m.find()) {
			System.out.println("Match \"" + m.group() + "\" at positions " +
				m.start() + "-" + (m.end() - 1 ));
		}
	}
	
	public static void main(String args[]) {
		String[] strArr = {"^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s?", "s*", "s+", "s{4}", "s{1}", "s{0,3}"};
		for(String regex : strArr) {
			match(regex);
		}
	}
	
}
