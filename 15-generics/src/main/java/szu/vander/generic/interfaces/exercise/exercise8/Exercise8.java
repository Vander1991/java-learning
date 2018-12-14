package szu.vander.generic.interfaces.exercise.exercise8;

/**
* @author      : Vander
* @date        : 2018-12-10
* @description ：  模仿Coffee示例的样子，根据你喜爱的电影人物，创建一个StoryCharacters的类层析结构，将它们划分为GoodGuys和
* 				BadGuys。再按照CoffeeGenerator的形式，编写一个StoryCharacters的生成器。
*/
public class Exercise8 {
	
	public static void main(String[] args) {
		StoryCharacterGenerator storyCharacterGenerator = new StoryCharacterGenerator(10);
		for(StoryCharacters sc : storyCharacterGenerator) {
			System.out.println(sc);
		}
	}
	
}
