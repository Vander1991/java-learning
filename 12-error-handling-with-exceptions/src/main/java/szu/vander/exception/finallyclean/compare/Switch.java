package szu.vander.exception.finallyclean.compare;

//: exceptions/Switch.java
import static szu.vander.util.Print.*;

public class Switch {
	private boolean state = false;

	public boolean read() {
		return state;
	}

	public void on() {
		state = true;
		print(this);
	}

	public void off() {
		state = false;
		print(this);
	}

	public String toString() {
		return state ? "on" : "off";
	}
} /// :~
