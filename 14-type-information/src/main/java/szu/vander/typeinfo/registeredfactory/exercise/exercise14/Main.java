package szu.vander.typeinfo.registeredfactory.exercise.exercise14;

/**
* @author      : Vander
* @date        : 2018-12-02
* @description ： 构造器是一种工厂方法。修改RegisteredFactories.java，使其不要使用显式
* 				的工厂，而是将类对象存储到List中，并使用newInstance()来创建对象
*/
public class Main {

	public static void main(String[] args) {
		Part part = new Part();
		for(int i=0; i<10; i++) {
			System.out.println(part.createRandom());
		}
	}

}
