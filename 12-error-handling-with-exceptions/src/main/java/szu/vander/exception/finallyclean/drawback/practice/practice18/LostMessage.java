package szu.vander.exception.finallyclean.drawback.practice.practice18;

//: exceptions/LostMessage.java
// How an exception can be lost.

/**
 * 
 * @author : Vander
 * @date : 2018-11-21
 * @description : 先抛出的VeryImportantException被后抛出的HoHumException所取代
 */
class VeryImportantException extends Exception {
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	public String toString() {
		return "A trivial exception";
	}
}

class MyException extends Exception {
	public String toString() {
		return "MyException";
	}
}

public class LostMessage {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	void test() throws MyException {
		throw new MyException();
	}

	public static void main(String[] args) {
		try {
			LostMessage lm = new LostMessage();
			try {
				try {
					lm.f();
				} finally {
					lm.dispose();
				}
			} finally {
				lm.test();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
} /*
	 * Output: A trivial exception
	 */// :~
