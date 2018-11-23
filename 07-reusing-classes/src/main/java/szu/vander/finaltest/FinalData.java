package szu.vander.finaltest;

import java.util.Random;
import static szu.vander.util.Print.*;
/**
* @author      : Vander
* @date        : 2018-11-09
* @description ： 
*/
public class FinalData {

	private static Random rand = new Random(47);
	
	private String id;
	
	public FinalData(String id) {
		this.id = id;
	}

	//valueOne VALUE_TWO都是编译期常量
	private final int valueOne = 9;
	private static final int VALUE_TWO = 99;
	
	public static final int VALUE_THREE = 999;
	
	// 定义为final说明是数值不能被改变
	private final int i4 = rand.nextInt(20);
	// 定义为static强调只有一份，这是因为装载的时候就初始化了
	static final int INT_5 = rand.nextInt(20);
	
	private Value v1 = new Value(11);
	
	// 不能因为是编译期常量就认为在编译时就知道它的值，运行时使用随机生成就说明了这点
	private final Value v2 = new Value(22);
	private static final Value VAL_3 = new Value(33);
	
	private final int[] a = {1, 2, 3, 4, 5};
	
	public String toString() {
		return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
	}
	
	public static void main(String args[]) {
		FinalData fd1 = new FinalData("fd1");
		// fd1.valueOne++ -> error final的基本类型不能改变
		fd1.v2.i++;
		fd1.v1 = new Value(9);
		for(int i = 0; i < fd1.a.length; i++) {
			fd1.a[i]++;
			// fd1.v2 = new Value(0) -> 对象的引用不能改变
			// fd1.VAL_3 = new Value(1) -> 对象的引用不能改变
			// fd1.a = new int[3]; ->对象的引用不能改变
		}
		print(fd1);
		print("Creating new FinalData");
		FinalData fd2 = new FinalData("fd2");
		print(fd1);
		print(fd2);		
	}
	
}

class Value {
	int i;
	public Value(int i) {
		this.i = i;
	}
}
