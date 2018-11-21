package szu.vander.exception.myexception.practice.practice2;

/**
* @author      : Vander
* @date        : 2018-11-20
* @description ： 
*/
public class Practice2 {

	public void test() {
		System.out.println("test");
	}
	
	public static void main(String args[]) {
		try {
			Practice2 p2 = null;
			p2.test();
		} catch(NullPointerException e) {
			e.printStackTrace();
		} finally {
			System.out.println("end the main");
		}
	}
	
}
