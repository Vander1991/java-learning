package szu.vander.string.regex.practices.practice9;

import szu.vander.string.regex.Splitting;

/**
* @author : Vander Choi
* @date : 2018-11-24
* @description : 检查一个句子是否是大写字母开头以。结尾的
*/
public class Practice9 {

	public final static String regex = "a|e|i|o|u";
	
	public static String test(String sentense) {
		return sentense.replaceAll(regex, "_");
	}
	
	public static void main(String args[]) {
		System.out.println(test(Splitting.knights));
	}
	
}
