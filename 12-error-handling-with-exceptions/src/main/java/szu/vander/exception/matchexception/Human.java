package szu.vander.exception.matchexception;

//: exceptions/Human.java
// Catching exception hierarchies.

class Annoyance extends Exception {
	private static final long serialVersionUID = -3140482162745516907L;
}

class Sneeze extends Annoyance {
	private static final long serialVersionUID = -2854098710011888064L;
}

public class Human {
	public static void main(String[] args) {
		// Catch the exact type:
		try {
			throw new Sneeze();
		} catch (Sneeze s) {
			System.out.println("Caught Sneeze");
		} catch (Annoyance a) {
			System.out.println("Caught Annoyance");
		}
		// Catch the base type:
		try {
			throw new Sneeze();
		} catch (Annoyance a) {
			System.out.println("Caught Annoyance");
		}
	}
} /*
	 * Output: Caught Sneeze Caught Annoyance
	 */// :~
