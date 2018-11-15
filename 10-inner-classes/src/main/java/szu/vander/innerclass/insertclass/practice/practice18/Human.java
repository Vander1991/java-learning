package szu.vander.innerclass.insertclass.practice.practice18;
/**
* @author      : Vander
* @date        : 2018-11-15
* @description ： 
*/
public class Human {

	static class Info {
		private String name;
		
		Info(String name){
			this.name = name;
		}
		
		public String toString() {
			return name;
		}
		
	}
	
	public static void main(String args[]) {
		System.out.println(new Human.Info("I am human being!!!"));
	}
	
}
