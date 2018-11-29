package szu.vander.string.regex;

import java.util.Arrays;

/**
 * 
 * @author     : Vander
 * @date       : 2018-11-24
 * @description: \W表示非单词字符作为分隔符（\w表示一个单词字符作为分隔符）
 * 				第三个表达式的意思是字母n后面跟一个或者多个非单词字符
 */
public class Splitting {
	public static String knights = "Then, when you have found the shrubbery, you must "
			+ "cut down the mightiest tree in the forest... " + "with... a herring!";

	public static void split(String regex) {
		System.out.println(Arrays.toString(knights.split(regex)));
	}

	public static void main(String[] args) {
		split(" "); // Doesn't have to contain regex chars
		split("\\W+"); // Non-word characters
		split("n\\W+"); // 'n' followed by non-word characters
	}
} /*
	 * Output: [Then,, when, you, have, found, the, shrubbery,, you, must, cut,
	 * down, the, mightiest, tree, in, the, forest..., with..., a, herring!] [Then,
	 * when, you, have, found, the, shrubbery, you, must, cut, down, the, mightiest,
	 * tree, in, the, forest, with, a, herring] [The, whe, you have found the
	 * shrubbery, you must cut dow, the mightiest tree i, the forest... with... a
	 * herring!]
	 */// :~
