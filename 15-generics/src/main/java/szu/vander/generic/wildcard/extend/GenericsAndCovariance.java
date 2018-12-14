package szu.vander.generic.wildcard.extend;

//: generics/GenericsAndCovariance.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-14
* @description : 
 */
public class GenericsAndCovariance {
	public static void main(String[] args) {
		// Wildcards allow covariance:
		List<? extends Fruit> flist = new ArrayList<Apple>();
		// Compile Error: can't add any type of object:
		//flist.add((Fruit)new Apple());
		// flist.add(new Fruit());
		// flist.add(new Object());
		flist.add(null); // Legal but uninteresting
		// We know that it returns at least Fruit:
		Fruit f = flist.get(0);
	}
} /// :~
