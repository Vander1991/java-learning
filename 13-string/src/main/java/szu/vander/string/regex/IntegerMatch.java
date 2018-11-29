package szu.vander.string.regex;

//: strings/IntegerMatch.java

/**
 * 
 * @author     : Vander
 * @date       : 2018-11-24
 * @description: java中\\意思是我要插入一个正则表达式的反斜杠，所以其后的字符具有特殊的意义
 * 				因为字符+在正则表达式中有特殊的意义所以必须用\\将其转义，|是或的意思
 */
public class IntegerMatch {
	public static void main(String[] args) {
		System.out.println("-1234".matches("-?\\d+"));
		System.out.println("5678".matches("-?\\d+"));
		System.out.println("+911".matches("-?\\d+"));
		System.out.println("+911".matches("(-|\\+)?\\d+"));
	}
}
