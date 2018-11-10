package szu.vander.desc;
/**
* @author      : Vander
* @date        : 2018-11-09
* @description ： 
*/
public class Desc {

	public static void main(String args[]) {

	}
	
	public void combineOrExtends() {
		String question = "how to choose combine or extends ?\n";
		String result = "使用组合和继承，最清晰的判断方法就是问一问自己是否需要从子类"
				+ "向基类进行向上转型。如果必须向上转型，则继承是必要的；但如果不需要，则"
				+ "应当好好考虑自己是否需要继承。";
		System.out.println(question + result);
	}
	
	public void finalWord() {
		String finalField = "将数据定义成final有两个原因：\n"
				+ "\r 1、一个永不改变的编译时常量。\n"
				+ "\r 2、一个在运行时被初始化的值，而你不希望它被改变。";
		String finalClass = "将final用于对象引用，final使引用恒定不变。";
	}
	
}
/**
 	惯例：既是static又是final的域要用大写表示，并使用下划线分隔各个单词
**/