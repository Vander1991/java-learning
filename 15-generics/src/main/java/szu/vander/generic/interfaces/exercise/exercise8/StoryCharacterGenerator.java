package szu.vander.generic.interfaces.exercise.exercise8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import szu.vander.util.Generator;

/**
* @author      : Vander
* @date        : 2018-12-10
* @description ： 
*/
public class StoryCharacterGenerator implements Generator<StoryCharacters>, Iterable<StoryCharacters> {

	private int size;
	
	private StoryCharacters[] characters;
	
	public StoryCharacterGenerator(int size) {
		this.size = size;
		characters = new StoryCharacters[size];
		for(int i=0; i<size; i++) {
			characters[i] = createRandom();
		}
	}
	
	private List<Class<? extends StoryCharacters>> types = Arrays.asList(Goku.class, Bic.class);
	
	private static Random random = new Random(47);
	
	private static class NullStoryCharacters extends StoryCharacters {
		public NullStoryCharacters() {
			super("no name");
		}
	}
	
	public StoryCharacters createRandom() {
		int randomNum = random.nextInt(types.size());
		try {
			return (StoryCharacters)types.get(randomNum).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return new NullStoryCharacters();
	}

	private class StoryCharactersIterator implements Iterator<StoryCharacters> {

		private int count = 0;
		
		@Override
		public boolean hasNext() {
			if(count < size) {
				return true;
			}
			return false;
		}

		@Override
		public StoryCharacters next() {
			if(hasNext()) {
				return characters[count++];
			}
			return null;
		}

	}
	
	@Override
	public Iterator<StoryCharacters> iterator() {
		return new StoryCharactersIterator();
	}

	@Override
	public StoryCharacters next() {
		return createRandom();
	}
	
}
