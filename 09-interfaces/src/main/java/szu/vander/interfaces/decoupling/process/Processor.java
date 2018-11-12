package szu.vander.interfaces.decoupling.process;
/**
* @author : Vander Choi
* @date : 2018-11-12
* @description :
*/
public class Processor {
	public String name() {
		return getClass().getSimpleName();
	}

	public Object process(Object input) {
		return input;
	}
}
