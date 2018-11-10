package szu.vander.combine;

import static szu.vander.util.Printer.*;

/**
* @author      : Vander
* @date        : 2018-11-02
* @description ： 组合对象初始化的四种方式：
* 						1、定义的时候初始化	2、构造器中初始化		
* 						3、使用对象前初始化	4、使用实例初始化
*/
public class CombineInit {

	private String 
		s1 = "Happy",
		s2 = "Happy",
		s3, s4;
	
	private Soap castile;
	
	private int i;
	
	private float toy;
	
	public CombineInit() {
		print("Inside ToString()");
		s3 = "joy";
		toy = 3.14f;
		castile = new Soap();
	}
	// 实例初始化
	{
		i = 47;
	}
	
	public String toString() {
		if(s4 == null) {
			s4 = "Joy";
		}
		String result = "s1 = " + s1 + "\n";
		result = result + "s2 = " + s2 + "\n";
		result = result + "s3 = " + s3 + "\n";
		result = result + "s4 = " + s4 + "\n";
		result = result + "i = " + i + "\n";
		result = result + "toy = " + toy + "\n";
		result = result + "castile = " + castile + "\n";
		
		return result;
		
	}
	
	public static void main(String[] args) {
		CombineInit t = new CombineInit();
		print(t);
	}

}

class Soap {
	private String s;
	
	Soap(){
		print("Soap()");
		s = "Constructed";
	}
	
	public String toString() {
		return s;
	}
	
}

