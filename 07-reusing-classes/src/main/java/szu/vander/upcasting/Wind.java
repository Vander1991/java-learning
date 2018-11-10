package szu.vander.upcasting;
/**
* @author      : Vander
* @date        : 2018-11-09
* @description ：  虽然向上转型了，但是调用的还是子类重写的方法 
*/
public class Wind extends Instrument {

	@Override
	public void play() {
		System.out.println("Wind play()");
	}
	
	public static void main(String args[]) {
		Wind wind = new Wind();
		// 此处向上转型
		Instrument.tune(wind);
	}
	// output:
	// Wind play()
}

class Instrument {
	
	public void play() {
		System.out.println("Instrument play()");
	}
	
	static void tune(Instrument i) {
		i.play();
	}
	
}
