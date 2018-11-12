package szu.vander.polymorphism.music;

import static szu.vander.util.Printer.*;

import java.util.Random;

/**
 * 
* @author      : Vander
* @date        : 2018-11-12
* @description ：  此处父类中的toString方法被重写了，打印子类的时候会找到子类对应的what方法，
* 				然后打印出子类what方法的内容
 */
public class Music {
	
	private static RandomInstrumentGenerator gen = new RandomInstrumentGenerator();
	
	public static void tune(Instrument i) {
		// ...
		i.play(Note.MIDDLE_C);
	}

	public static void tuneAll(Instrument[] e) {
		for (Instrument i : e) {
			tune(i);
		}
	}

	public static void showAll(Instrument[] e) {
		for (Instrument i : e) {
			print(i);
		}
	}
	
	public static void main(String[] args) {
		// Upcasting during addition to the array:
		Instrument[] orchestra = new Instrument[20];
		for(int i=0; i<orchestra.length; i++) {
			orchestra[i] = gen.next();
		}
		showAll(orchestra);
//		tuneAll(orchestra);
	}
}

class Instrument {
	void play(Note n) {
		print("Instrument.play() " + n);
	}

	String what() {
		return "Instrument";
	}

	void adjust() {
		print("Adjusting Instrument");
	}
	
	@Override
	public String toString() {
		return what();
	}
	
}

class Wind extends Instrument {
	void play(Note n) {
		print("Wind.play() " + n);
	}

	String what() {
		return "Wind";
	}

	void adjust() {
		print("Adjusting Wind");
	}
}

class Percussion extends Instrument {
	void play(Note n) {
		print("Percussion.play() " + n);
	}

	String what() {
		return "Percussion";
	}

	void adjust() {
		print("Adjusting Percussion");
	}
}

class Stringed extends Instrument {
	void play(Note n) {
		print("Stringed.play() " + n);
	}

	String what() {
		return "Stringed";
	}

	void adjust() {
		print("Adjusting Stringed");
	}
}

class Brass extends Wind {
	void play(Note n) {
		print("Brass.play() " + n);
	}

	void adjust() {
		print("Adjusting Brass");
	}
}

class Woodwind extends Wind {
	void play(Note n) {
		print("Woodwind.play() " + n);
	}

	String what() {
		return "Woodwind";
	}
}

class RandomInstrumentGenerator {

	private Random rand = new Random(47);

	public Instrument next() {
		switch (rand.nextInt(5)) {
		default:
		case 0:
			return new Woodwind();
		case 1:
			return new Brass();
		case 2:
			return new Stringed();
		case 3:
			return new Percussion();
		case 4:
			return new Wind();
		}
	}

}


