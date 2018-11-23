package szu.vander.exception.discussion.practice.practice29;

/**
 * 
* @author      : Vander
* @date        : 2018-11-21
* @description : 对于RuntimeException，继承的方法的异常限制都不存在了。
* 					继承的方法的异常限制：
* 						1、父类方法抛了异常，子类方法可以不抛异常，父类方法没有抛异常，子类方法也不能抛异常，满足子类异常范围更大原则
* 
 */					
class BaseballException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}

class Foul extends BaseballException {
	private static final long serialVersionUID = 1L;
}

class Strike extends BaseballException {
	private static final long serialVersionUID = 1L;
}

abstract class Inning {
	public Inning() throws BaseballException {
	}

	// 强制用户去捕获可能在覆盖后的event()版本中增加的异常
	public void event() throws BaseballException {
		// Doesn't actually have to throw anything
	}

	public abstract void atBat() throws Strike, Foul;

	public void walk() {
	} // Throws no checked exceptions
}

class StormException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}

class RainedOut extends StormException {
	private static final long serialVersionUID = 1L;
}

class PopFoul extends Foul {
	private static final long serialVersionUID = 1L;
}

interface Storm {
	public void event() throws RainedOut;

	public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {

	public StormyInning() throws RainedOut, BaseballException {
	}

	public StormyInning(String s) throws Foul, BaseballException {
	}

	public void walk() throws PopFoul {
	}
	
	public void event() throws RainedOut {
	}
	
	public void rainHard() throws RainedOut {
	}

	public void atBat() throws PopFoul {
	}

	public static void main(String[] args) {
		StormyInning si = new StormyInning();
		si.atBat();
		Inning i = new StormyInning();
		i.atBat();
	}
}
