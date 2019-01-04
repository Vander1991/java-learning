package szu.vander.generic.compensatinglatenttyping;

//: generics/Fill.java
// Generalizing the FilledList idea
// {main: FillTest}
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import szu.vander.util.SimpleQueue;

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-02
 * @description: Fill中的fill方法的限制就是，如果第一个参数不是Collection的实现，那么就没法使用了，
 * 				因此这样的代码不算是特别泛化，一种解决的方法是使用适配器来适配这个接口,具体请看Fill2.java
 */
public class Fill {
	public static <T> void fill(Collection<T> collection, Class<? extends T> classToken, int size) {
		for (int i = 0; i < size; i++)
			// Assumes default constructor:
			try {
				collection.add(classToken.newInstance());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
}

class Contract {
	private static long counter = 0;
	private final long id = counter++;

	public String toString() {
		return getClass().getName() + " " + id;
	}
}

class TitleTransfer extends Contract {
}

class FillTest {
	public static void main(String[] args) {
		List<Contract> contracts = new ArrayList<Contract>();
		Fill.fill(contracts, Contract.class, 3);
		Fill.fill(contracts, TitleTransfer.class, 2);
		for (Contract c : contracts) {
			System.out.println(c);
		}
		SimpleQueue<Contract> contractQueue = new SimpleQueue<Contract>();
		// Won't work. fill() is not generic enough:
		// Fill.fill(contractQueue, Contract.class, 3);
	}
} /*
	 * Output: Contract 0 Contract 1 Contract 2 TitleTransfer 3 TitleTransfer 4
	 */// :~
