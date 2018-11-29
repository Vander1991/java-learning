package szu.vander.string.regex;

import java.util.regex.*;
import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-29
* @description : Matcher对象提供了一系列方法，用以获取与组相关的信息：
* 					public int groupCount()返回该匹配器的模式中的分组数目，第0组不包括在内
* 					public String group()返回前一次匹配操作的第0组
* 					?m匹配多行
* 					?s匹配单行
* 					$是一行的结束
* 					\s是空白符
* 					\S是非空白符
* 					这句的意思是匹配最后三个单词
 */
public class Groups {
	static public final String POEM = 
			"Twas brillig, and the slithy toves\n" 
			+ "Did gyre and gimble in the wabe.\n"
			+ "All mimsy were the borogoves,\n" 
			+ "And the mome raths outgrabe.\n\n"
			+ "Beware the Jabberwock, my son,\n" 
			+ "The jaws that bite, the claws that catch.\n"
			+ "Beware the Jubjub bird, and shun\n" 
			+ "The frumious Bandersnatch.";

	public static void main(String[] args) {
		Matcher m = Pattern.compile("(?m)(\\S+)\\s+(\\S+\\s+\\S+)$").matcher(POEM);
		while (m.find()) {
			for (int j = 0; j <= m.groupCount(); j++) {
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
