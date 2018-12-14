//: generics/coffee/Coffee.java
package szu.vander.generic.interfaces.coffee;

public class Coffee {
	private static long counter = 0;
	private final long id = counter++;

	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
}
