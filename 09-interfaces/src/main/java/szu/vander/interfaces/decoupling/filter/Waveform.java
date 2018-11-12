//: interfaces/filters/Waveform.java
package szu.vander.interfaces.decoupling.filter;

public class Waveform {
	private static long counter;
	private final long id = counter++;

	public String toString() {
		return "Waveform " + id;
	}
}
