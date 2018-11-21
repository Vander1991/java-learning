package szu.vander.exception.finallyclean.compare;

//: exceptions/WithFinally.java
// Finally Guarantees cleanup.

/**
 * 
* @author      : Vander
* @date        : 2018-11-21
* @description : 有了finally之后关闭的操作就能保证一定会运行，不需要在三个地方写关闭的代码
 */
public class WithFinally {
	static Switch sw = new Switch();

	public static void main(String[] args) {
		try {
			sw.on();
			// Code that can throw exceptions...
			OnOffSwitch.f();
		} catch (OnOffException1 e) {
			System.out.println("OnOffException1");
		} catch (OnOffException2 e) {
			System.out.println("OnOffException2");
		} finally {
			sw.off();
		}
	}
} /*
	 * Output: on off
	 */// :~
