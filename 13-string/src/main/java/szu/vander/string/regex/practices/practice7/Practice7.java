package szu.vander.string.regex.practices.practice7;
/**
* @author : Vander Choi
* @date : 2018-11-24
* @description : 检查一个句子是否是大写字母开头以。结尾的
*/
public class Practice7 {

	public final static String regex = "^[A-Z][a-z| ]+.";
	
	public final static String regex1 = "^[A-Z].*\\.";
	
	public static void test(String sentense) {
		System.out.println(sentense.matches(regex));
	}
	
	public static void main(String args[]) {
		test("I am Vander.");
		test("You are vander.");
		test("Are .");
	}
	
}
