package szu.vander.util;
/**
* @author      : Vander
* @date        : 2018-12-10
* @description ： 
*/
public class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E>{

	private final F sixth;
	
	public SixTuple(A a, B b, C c, D d, E e, F sixth) {
		super(a, b, c, d, e);
		this.sixth = sixth;
	}
	
	public String toString() {
		return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + ", "
				+ sixth + " )";
	}
	
}
