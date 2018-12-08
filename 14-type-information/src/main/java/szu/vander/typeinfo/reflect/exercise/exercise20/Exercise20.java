package szu.vander.typeinfo.reflect.exercise.exercise20;

/**
* @author : Vander Choi
* @date : 2018-12-07
* @description : 找到JDK文档中的java.lang.class接口，写一个程序，使它能够接受命令行参数所指定的类名称。然后使用Class的方法打印该类所有可以获得的信息
* 				用标准程序库的类和你自己写的类，分别测试这个程序。 
* 
*/
public class Exercise20 {

	public static void main(String args[]) {
		ClassDesc.printClassDetail("szu.vander.typeinfo.reflect.exercise.exercise19.FancyToy");
	}
		
}
