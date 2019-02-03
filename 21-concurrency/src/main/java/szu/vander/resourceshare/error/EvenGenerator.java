package szu.vander.resourceshare.error;

//: concurrency/EvenGenerator.java
// When threads collide.

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-19
 * @description: 如果希望更快的发现失败，可以在第一句++currentEvenValue;后加上yield。
 * 				要注意到递增程序自身需要多个步骤，并且在递增过程中的任务可以被线程机制挂起，也就是说
 * 				Java中，递增不是原子性的操作，因此，如果不保护任务，即使单一的递增也不是安全的。
 */
public class EvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;

	public int next() {
		++currentEvenValue; // Danger point here!
		++currentEvenValue;
		return currentEvenValue;
	}

	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}
} /*
	 * Output: (Sample) Press Control-C to exit 89476993 not even! 89476993 not
	 * even!
	 */// :~
