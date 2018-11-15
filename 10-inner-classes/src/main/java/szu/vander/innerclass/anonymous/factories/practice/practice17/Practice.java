package szu.vander.innerclass.anonymous.factories.practice.practice17;
/**
* @author      : Vander
* @date        : 2018-11-15
* @description ： 
*/
interface Game {
	void play();
}

class TossingCoinGame implements Game {

	public void play() {
		System.out.println("Tossing the Coin");
	}
	
	public static GameFactory gameFactory = new GameFactory() {
		public Game getGame() {
			return new TossingCoinGame();
		}
	};
	
}

class ShakeElbowGame implements Game {

	public void play() {
		System.out.println("Shake the Elbow");
	}
	
	public static GameFactory gameFactory = new GameFactory() {
		public Game getGame() {
			return new ShakeElbowGame();
		}
	};
	
}

interface GameFactory {
	Game getGame();
}

public class Practice {
	
	public static void playGame(GameFactory gameFactory) {
		gameFactory.getGame().play();
	}
	
	public static void main(String args[]) {
		playGame(ShakeElbowGame.gameFactory);
		playGame(TossingCoinGame.gameFactory);
	}
}
