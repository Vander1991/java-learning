package szu.vander.interfaces.adapt;

import java.util.*;

public class RandomDoubles {
	private static Random rand = new Random(47);

	public double next() {
		return rand.nextDouble();
	}

	public static void main(String[] args) {
		RandomDoubles rd = new RandomDoubles();
		Scanner scanner = new Scanner(new AdaptedRandomDoubles(5, rd));
		while(scanner.hasNext()) {
			System.out.println(scanner.next());
		}
	}
}
