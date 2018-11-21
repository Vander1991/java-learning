package szu.vander.exception.finallyclean.drawback;

//: exceptions/LostMessage.java
// How an exception can be lost.

/**
 * 
* @author      : Vander
* @date        : 2018-11-21
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

public class LostMessage {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	public static void main(String[] args) {
		try {
			LostMessage lm = new LostMessage();
			try {
				lm.f();
			} finally {
				lm.dispose();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
} /*
	 * Output: A trivial exception
	 */// :~
