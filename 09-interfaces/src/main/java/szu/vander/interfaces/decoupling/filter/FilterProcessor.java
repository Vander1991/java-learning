package szu.vander.interfaces.decoupling.filter;

import szu.vander.interfaces.decoupling.process.Processor;

/**
* @author : Vander Choi
* @date : 2018-11-12
* @description :
*/
public class FilterProcessor extends Processor {

	private Filter filter;
	
	public FilterProcessor(Filter filter) {
		this.filter = filter;
	}
	
	public String name() {
		return filter.name();
	}
	
	public Waveform process(Object input) {
		return filter.process((Waveform)input);
	}
	
}
