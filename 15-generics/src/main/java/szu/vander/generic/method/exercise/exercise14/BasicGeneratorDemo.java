package szu.vander.generic.method.exercise.exercise14;

import szu.vander.generic.method.BasicGenerator;
import szu.vander.generic.method.CountedObject;
import szu.vander.util.Generator;

public class BasicGeneratorDemo {
	public static void main(String[] args) {
		Generator<CountedObject> gen = new BasicGenerator<CountedObject>(CountedObject.class);
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
	}
} /*
	 * Output: CountedObject 0 CountedObject 1 CountedObject 2 CountedObject 3
	 * CountedObject 4
	 */// :~
