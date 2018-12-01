package szu.vander.string.format;

//: strings/Receipt.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-23
* @description : %[argument_index$][flag][width][.precision]conversion
 */
public class Receipt {
	private double total = 0;
	private Formatter f = new Formatter(System.out);

	public void printTitle() {
		f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
		f.format("%-15s %5s %10s\n", "----", "---", "-----");
	}

	public void print(String name, int qty, double price) {
		// 默认情况下是右对齐的，加“-”就变成了左对齐
		f.format("%-15.15s %5d %10.2f\n", name, qty, price);
		total += price;
	}

	public void printTotal() {
		f.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
		f.format("%-15s %5s %10s\n", "", "", "-----");
		f.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);
	}

	public static void main(String[] args) {
		Receipt receipt = new Receipt();
		receipt.printTitle();
		// 只要15个字符，所以ans后面的都不显示了
		receipt.print("Jack's Magic Beans", 4, 4.25);
		receipt.print("Princess Peas", 3, 5.1);
		receipt.print("Three Bears Porridge", 1, 14.29);
		receipt.printTotal();
	}
} /*
	 * Output: Item Qty Price ---- --- ----- Jack's Magic Be 4 4.25 Princess Peas 3
	 * 5.10 Three Bears Por 1 14.29 Tax 1.42 ----- Total 25.06
	 */// :~