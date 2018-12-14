package szu.vander.generic.interfaces.exercise.exercise8;
/**
* @author      : Vander
* @date        : 2018-12-10
* @description ： 
*/
public class BadGuys extends StoryCharacters {

	public BadGuys() {
		
	}
	
	public BadGuys(String name) {
		super(name);
	}

	static class Desc {
		public static String getDesc() {
			return "I am bad guy!";
		}
	}
	
}
