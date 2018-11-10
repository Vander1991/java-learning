package szu.vander.finaltest;

/**
 * 
 * @author     : Vander
 * @date       : 2018-11-10
 * @description: 空白final：是指声明为final但又未给定初值的域，一个类中的final域可以做到根据对象而有所不同
 * 				 却又保持其恒定不变的特性，必须在域的定义处或者每个构造器中用表达式对final进行赋值
 */
public class BlankFinal {
	
	// Initialized final
	private final int i = 0;
	
	// Blank final
	private final int j; 
	// Blank final reference
	private final Poppet p;
	// Blank finals MUST be initialized in the constructor:

	public BlankFinal() {
		j = 1; // Initialize blank final
		p = new Poppet(1); // Initialize blank final reference
	}

	public BlankFinal(int x) {
		j = x; // Initialize blank final
		p = new Poppet(x); // Initialize blank final reference
	}

	public static void main(String[] args) {
		new BlankFinal();
		new BlankFinal(47);
	}
}

class Poppet {
	private int i;
	Poppet(int ii) {
		i = ii;
	}
}
