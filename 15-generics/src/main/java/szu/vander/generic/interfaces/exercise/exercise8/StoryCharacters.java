package szu.vander.generic.interfaces.exercise.exercise8;
/**
* @author      : Vander
* @date        : 2018-12-10
* @description ：  故事人物
*/
public class StoryCharacters {

	protected String name;

	public StoryCharacters() {
		
	}
	
	public StoryCharacters(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StoryCharacters [name=" + name + "]";
	}
	
}
