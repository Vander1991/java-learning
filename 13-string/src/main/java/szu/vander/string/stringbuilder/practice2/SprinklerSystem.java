package szu.vander.string.stringbuilder.practice2;

/**
 * 
* @author      : Vander
* @date        : 2018-11-23
* @description : 使用StringBuilder在toString这里是一样的
 */
class WaterSource {
	private String s;

	WaterSource() {
		System.out.println("WaterSource()");
		s = "Constructed";
	}

	public String toString() {
		return s;
	}
}

public class SprinklerSystem {
	private String valve1, valve2, valve3, valve4;
	private WaterSource source = new WaterSource();
	private int i;
	private float f;

	public String toString() {
		return "valve1 = " + valve1 + " " + "valve2 = " + valve2 + " " + "valve3 = " + valve3 + " " + "valve4 = "
				+ valve4 + "\n" + "i = " + i + " " + "f = " + f + " " + "source = " + source;
	}

	public String testToString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("valve1 = ")
		.append(valve1).append(" ")
		.append("valve2 = ").append(valve2)
		.append(" ").append("valve3 ")
		.append(valve3).append(" ")
		.append("valve4 = ").append(valve4);
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		SprinklerSystem sprinklers = new SprinklerSystem();
		System.out.println(sprinklers);
	}
}
