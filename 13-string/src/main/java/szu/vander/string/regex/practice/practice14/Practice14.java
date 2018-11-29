package szu.vander.string.regex.practice.practice14;

import static szu.vander.util.Print.print;

import java.util.Arrays;

/**
 * 
* @author      : Vander
* @date        : 2018-11-29
* @description : 第二种形式可以限制将输入分割成字符串的数量
 */
public class Practice14 {
	public static void main(String[] args) {
		String input = "This!!unusual use!!of exclamation!!points";
		print(Arrays.toString(input.split("!!")));
		print(Arrays.toString(input.split("!!", 3)));
	}
} /*
	 * Output: [This, unusual use, of exclamation, points] [This, unusual use, of
	 * exclamation!!points]
	 */// :~
