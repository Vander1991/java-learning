package szu.vander.exception.finallyclean.compare;

//: exceptions/OnOffSwitch.java
// Why use finally?

/**
 * 
* @author      : Vander
* @date        : 2018-11-21
* @description : 没有用finally只能这么写关闭，并且假设执行on()、off()函数中有RuntimeException，则有可能
* 				导致开关没有被正确关闭
 */
public class OnOffSwitch {
	private static Switch sw = new Switch();

	public static void f() throws OnOffException1, OnOffException2 {
	}

	public static void main(String[] args) {
		try {
			sw.on();
			// Code that can throw exceptions...
			f();
			sw.off();
		} catch (OnOffException1 e) {
			System.out.println("OnOffException1");
			sw.off();
		} catch (OnOffException2 e) {
			System.out.println("OnOffException2");
			sw.off();
		}
	}
} /*
	 * Output: on off
	 */// :~
