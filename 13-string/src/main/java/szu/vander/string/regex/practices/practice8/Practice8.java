package szu.vander.string.regex.practices.practice8;

import java.util.Arrays;

import szu.vander.string.regex.Splitting;

/**
* @author : Vander Choi
* @date : 2018-11-24
* @description : 检查一个句子是否是大写字母开头以。结尾的
*/
public class Practice8 {

	public final static String regex = "the|you";
	
	public static String test(String sentense) {
		return Arrays.toString(sentense.split(regex));
	}
	
	public static void main(String args[]) {
		System.out.println(test(Splitting.knights));
	}
	
}
