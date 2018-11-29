package szu.vander.string.read;

//: strings/BetterRead.java
import java.util.Scanner;

/**
 * 
* @author      : Vander
* @date        : 2018-11-29
* @description : JDK1.5引入Scanner之后使得读取更加简便
* 				这里没有针对IOException添加try区，Scanner有一个假设，在输入结束时会抛出IOException，所以Scanner会
* 				吞掉它，不过通过ioException()方法可以找到最近发生的异常
 */
public class BetterRead {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(SimpleRead.input);
		System.out.println("What is your name?");
		String name = stdin.nextLine();
		System.out.println(name);
		System.out.println("How old are you? What is your favorite double?");
		System.out.println("(input: <age> <double>)");
		int age = stdin.nextInt();
		double favorite = stdin.nextDouble();
		System.out.println(age);
		System.out.println(favorite);
		System.out.format("Hi %s.\n", name);
		System.out.format("In 5 years you will be %d.\n", age + 5);
		System.out.format("My favorite double is %f.", favorite / 2);
	}
}
