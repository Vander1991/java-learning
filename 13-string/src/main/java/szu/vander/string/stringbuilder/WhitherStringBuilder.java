package szu.vander.string.stringbuilder;

//: strings/WhitherStringBuilder.java

/**
 * 
* @author      : Vander
* @date        : 2018-11-23
* @description : 通过使用javap -c 反编译发现，第一种直接用String的，会在循环内部多次创建StringBuilder，而第二种则先创建出
* 				StringBuilder
 */
public class WhitherStringBuilder {
	public String implicit(String[] fields) {
		String result = "";
		for (int i = 0; i < fields.length; i++)
			result += fields[i];
		return result;
	}

	public String explicit(String[] fields) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < fields.length; i++)
			result.append(fields[i]);
		return result.toString();
	}
}
