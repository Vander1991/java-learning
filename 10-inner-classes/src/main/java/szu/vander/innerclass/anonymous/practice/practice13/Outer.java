package szu.vander.innerclass.anonymous.practice.practice13;
/**
* @author      : Vander
* @date        : 2018-11-14
* @description ： 
*/
interface Shape {
	void draw(String content);
}

public class Outer {

	public Shape getShape() {
		return new Shape() {
			public void draw(String content) {
				System.out.println("Drawing a circle");
			}
			
			public String toString() {
				return "I am a circle";
			}
			
		};
	}
	
	public static void printShape(Shape shape) {
		System.out.println(shape);
	}
	
	public static void main(String args[]) {
		printShape(new Outer().getShape());
	}
	
}
