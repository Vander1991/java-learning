package szu.vander.array;

/**
 * @author : Vander
 * @date : 2019-01-05
 * @description:
 */
public class BerylliumSphere {
	private static long counter;
	private final long id = counter++;

	public String toString() {
		return "Sphere " + id;
	}
}
