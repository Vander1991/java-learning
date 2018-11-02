package szu.vander.init.enumorder;
/**
* @author      : Vander
* @date        : 2018-11-01
* @description ： 
*/
public class EnumOrder {
	
	public static void main(String args[]) {
		for(Spiciness s : Spiciness.values()) {
			System.out.println(s + "  Ordinal " + s.ordinal());
		}
	}
	
}
