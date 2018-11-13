package szu.vander.interfaces.adapt;

import java.io.IOException;
import java.nio.CharBuffer;

/**
* @author      : Vander
* @date        : 2018-11-13
* @description ：  此处再次使用适配器模式，被适配的类可以通过继承和实现Readable接口来创建。
* 				通过使用interface关键字提供的伪多重继承机制，我们可以生成既是RandomDoubles又是
* 				Readable的新类
*/
public class AdaptedRandomDoubles extends RandomDoubles implements Readable {

	private int count;
	
	private RandomDoubles randomDoubles;
	
	public AdaptedRandomDoubles(int number, RandomDoubles randomDoubles) {
		this.count = number;
		this.randomDoubles = randomDoubles;
	}
	
	public int read(CharBuffer cb) throws IOException {
		// count不为-1的情况下，外部调用hasNext会一直有值，这里就会一直被调用
		if (count-- == 0)
			return -1; // Indicates end of input
		char[] doublesArrs = (randomDoubles.next() + "").toCharArray();
		for(char c : doublesArrs) {
			cb.append(c);
		}
		// 最后拼接个空格能换行
		cb.append(" ");
		return doublesArrs.length;
	}
	
}
