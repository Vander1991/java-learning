package szu.vander.generic.simple.exercise.exercise6;

/**
 * 
* @author      : Vander
* @date        : 2018-12-10
* @description : 使用RandomList来处理两种额外的不同类型的元素，要区别于main()中已经用过的类型
 */
public class Exercise6 {
	
	public static void main(String[] args) {
		RandomList<Integer> randomList = new RandomList<Integer>();
		for(int i=0; i<10; i++) {
			randomList.add(i);
		}
		System.out.println(randomList.select());
	}
	
}
