package szu.vander.generic.wildcard.extend;

//: generics/GenericsAndCovariance.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-14
* @description : List<? extends Fruit>可以独坐“具有任何从Fruit继承的类型的列表，但是这实际上并不意味着这List将持有任何
* 				类型的Fruit”。通配符引用的是明确的类型，它意味着“某种flist引用没有指明的具体类型”
* 				既然flist没有确定的类型，所以放什么进去都会报错
 */
public class GenericsAndCovariance {
	public static void main(String[] args) {
		// Wildcards allow covariance:
		List<? extends Fruit> flist = Arrays.asList(new Apple());
		// Compile Error: can't add any type of object:
		// flist.add((Fruit)new Apple());
		// flist.add(new Fruit());
		// flist.add(new Object());
		// 这里虽然不报错，但是运行起来依然会抛出 UnsupportedOperationException
		flist.add(null); // Legal but uninteresting
		// We know that it returns at least Fruit:
		Fruit f = flist.get(0);
		System.out.println(f);
	}
} /// :~
