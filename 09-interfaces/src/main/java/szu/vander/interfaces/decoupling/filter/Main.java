package szu.vander.interfaces.decoupling.filter;
/**
* @author : Vander Choi
* @date : 2018-11-12
* @description :
*/
public class Main {

	public static void main(String[] args) {
		new FilterProcessor(new LowPass(100));
	}

}
