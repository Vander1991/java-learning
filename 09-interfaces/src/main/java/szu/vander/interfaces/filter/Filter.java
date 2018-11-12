package szu.vander.interfaces.filter;

/**
 * 
* @author      : Vander
* @date        : 2018-11-12
* @description ：  这里想将Filter作为参数用于Apply.process中，但是由于Apply.process()与Processor间
* 				 的耦合过紧，所以无法直接复用，此时可以通过适配器模式完成
 */
public class Filter {
	public String name() {
		return getClass().getSimpleName();
	}

	public Waveform process(Waveform input) {
		return input;
	}
}
