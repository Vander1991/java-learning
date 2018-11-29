package szu.vander.string.read;


//: strings/ScannerDelimiter.java
import java.util.Scanner;

/**
 * 
* @author      : Vander
* @date        : 2018-11-29
* @description : 使用useDelimiter()来设置定界符
* 				这里使用逗号及其附近的空格作为界定符
 */
public class ScannerDelimiter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner("12, 42, 78, 99, 42");
		scanner.useDelimiter("\\s*,\\s*");
		while (scanner.hasNextInt())
			System.out.println(scanner.nextInt());
	}
} /*
	 * Output: 12 42 78 99 42
	 */// :~
