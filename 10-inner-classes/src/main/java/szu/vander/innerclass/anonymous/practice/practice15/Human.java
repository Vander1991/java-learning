package szu.vander.innerclass.anonymous.practice.practice15;
/**
* @author      : Vander
* @date        : 2018-11-15
* @description ： 
*/
public class Human {

	private String name;
	
	public Human(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	class Inner {
		public Human getHuman() {
			return Human.this;
		}
	}
	
	public Human getHuman(String humanName) {
		// 相当于调用了父类的构造函数
		return new Human(humanName) {
			{
				System.out.println("Init begin");
			}
			public String toString() {
				return "I'm " + this.getName();
			}
		};
	}
	
	public static void main(String args[]) {
		System.out.println(new Human("Outer Human").getHuman("Inner Human"));
	}
	
}
