package szu.vander.interfaces.factory;

// A Game framework using Factory Methods.
import static szu.vander.util.Printer.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-13
* @description ：  引入工厂的作用就是：
* 					西洋棋工厂产生西洋棋的游戏、国际象棋的工厂生产国际象棋的游戏
* 					客户端只跟工厂接口绑定，不跟具体的工厂对象绑定，也就是说需要什么游戏就传什么游戏工厂即可
* 					使用匿名内部类能实现更优雅的工厂实现方法
 */
interface Game {
	boolean move();
}

interface GameFactory {
	Game getGame();
}

class Checkers implements Game {
	// Checkers - 西洋棋
	private int moves = 0;
	private static final int MOVES = 3;

	public boolean move() {
		print("Checkers move " + moves);
		return ++moves != MOVES;
	}
}

class CheckersFactory implements GameFactory {
	public Game getGame() {
		return new Checkers();
	}
}

class Chess implements Game {
	private int moves = 0;
	private static final int MOVES = 4;

	public boolean move() {
		print("Chess move " + moves);
		return ++moves != MOVES;
	}
}

class ChessFactory implements GameFactory {
	public Game getGame() {
		return new Chess();
	}
}

public class Games {
	public static void playGame(GameFactory factory) {
		Game s = factory.getGame();
		while (s.move())
			;
	}

	public static void main(String[] args) {
		playGame(new CheckersFactory());
		playGame(new ChessFactory());
	}
} /*
	 * Output: Checkers move 0 Checkers move 1 Checkers move 2 Chess move 0 Chess
	 * move 1 Chess move 2 Chess move 3
	 */// :~
