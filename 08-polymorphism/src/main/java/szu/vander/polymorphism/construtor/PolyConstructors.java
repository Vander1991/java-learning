package szu.vander.polymorphism.construtor;

// Constructors and polymorphism
// don't produce what you might expect.
import static szu.vander.util.Printer.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-12
* @description ：  从这个例子的输出效果来看，父类的draw方法确实被子类覆盖了，但是输出的radius值却不是1而是0，这是
* 				由于在调用子类的draw方法的时候，子类对象还没有实例化出来，仅仅是分配了空间并且置为0了，前面的初始化
* 				的过程没有说清楚。
* 			初始化的实际过程：
* 				1、在其他任何事物发生之前，将分配给对象的存储空间初始化成二进制的零
* 				2、如前所述那样调用基类构造器，此时，调用呗覆盖后的draw()方法（要在调用R偶读Glyph构造器之前调用），
* 				由于步骤一的关系，此时的redius值为0
* 				3、按照声明顺序调用成员的初始化方法
* 				4、调用导出类的构造器主体
* 				
 */
class Glyph {
	void draw() {
		print("Glyph.draw()");
	}

	Glyph() {
		print("Glyph() before draw()");
		draw();
		print("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;

	RoundGlyph(int r) {
		radius = r;
		print("RoundGlyph.RoundGlyph(), radius = " + radius);
	}

	void draw() {
		print("RoundGlyph.draw(), radius = " + radius);
	}
}

public class PolyConstructors {
	public static void main(String[] args) {
		new RoundGlyph(5);
	}
} /*
	 * Output: Glyph() before draw() RoundGlyph.draw(), radius = 0 Glyph() after
	 * draw() RoundGlyph.RoundGlyph(), radius = 5
	 */// :~
