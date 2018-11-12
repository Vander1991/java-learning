package szu.vander.interfaces.decoupling.filter;

/**
 * 
* @author      : Vander
* @date        : 2018-11-12
* @description ：  这里想将Filter作为参数用于Apply.process中，但是由于Apply.process()与Processor间
* 				 的耦合过紧，所以无法直接复用，此时可以通过适配器模式完成多种不同的具体实现，因此代码也更具有复用性
* 					将接口从具体实现中解耦使得接口可以应用于
 */
public class Filter {
	public String name() {
		return getClass().getSimpleName();
	}

	public Waveform process(Waveform input) {
		return input;
	}
}
