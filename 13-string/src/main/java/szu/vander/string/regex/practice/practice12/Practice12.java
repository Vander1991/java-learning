package szu.vander.string.regex.practice.practice12;

import java.util.regex.*;
import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-29
* @description : 找出所有不以大写字母开头的词，不重复计算其个数 
* 
 */
public class Practice12 {
	static public final String POEM = 
			"twas brillig, and the slithy toves\n" 
			+ "Did gyre and gimble in the wabe.\n"
			+ "All mimsy were the borogoves,\n" 
			+ "And the mome raths outgrabe.\n\n"
			+ "Beware the Jabberwock, my son,\n" 
			+ "The jaws that bite, the claws that catch.\n"
			+ "Beware the Jubjub bird, and shun\n" 
			+ "The frumious Bandersnatch.";

	public static void main(String[] args) {
		// mine
		Matcher m = Pattern.compile("(?m)([a-z]+)").matcher(POEM);
		// answer
//		Matcher m = Pattern.compile("\\b((?![A-Z])\\w+)\\b").matcher(POEM);
		while (m.find()) {
			for (int j = 1; j <= m.groupCount(); j++) {
				printnb("[" + m.group(j) + "]");
			}
			print();
		}
	}
} /*
	 * Output: [the slithy toves][the][slithy toves][slithy][toves] [in the
	 * wabe.][in][the wabe.][the][wabe.] [were the borogoves,][were][the
	 * borogoves,][the][borogoves,] [mome raths outgrabe.][mome][raths
	 * outgrabe.][raths][outgrabe.] [Jabberwock, my son,][Jabberwock,][my
	 * son,][my][son,] [claws that catch.][claws][that catch.][that][catch.] [bird,
	 * and shun][bird,][and shun][and][shun] [The frumious
	 * Bandersnatch.][The][frumious Bandersnatch.][frumious][Bandersnatch.]
	 */// :~
