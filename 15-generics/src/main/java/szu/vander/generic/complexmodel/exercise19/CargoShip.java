package szu.vander.generic.complexmodel.exercise19;

import java.util.ArrayList;

import szu.vander.util.Generator;
import szu.vander.util.Generators;

/**
* @author      : Vander
* @date        : 2018-12-11
* @description ： 参考Store.java的写法，构造一个货船模型
*/
class Product {
	private static int counter = 0;
	private final int productId = counter++;

	public String toString() {
		return "Product" + productId;
	}
	
	public static Generator<Product> generator() {
		return new Generator<Product>() {
			@Override
			public Product next() {
				return new Product();
			}
		};
	}
}

class Container extends ArrayList<Product> {
	private static final long serialVersionUID = 1L;

	public Container(int num) {
		Generators.fill(this, Product.generator(), num);
	}
}

class CargoHold extends ArrayList<Container> {
	
	private static final long serialVersionUID = 1L;

	public CargoHold(int containerNum, int productNum) {
		for(int i=0; i<containerNum; i++) {
			add(new Container(productNum));
		}
	}
	
}

public class CargoShip extends ArrayList<CargoHold> {

	private static final long serialVersionUID = 1L;

	public CargoShip(int cargoHoldNum, int containerNum, int productNum) {
		for(int i=0; i<cargoHoldNum; i++) {
			add(new CargoHold(containerNum, productNum));
		}
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (CargoHold cargoHold : this) {
			for (Container container : cargoHold) {
				for (Product product : container) {
					result.append(product);
					result.append("\n");
				}
			}
		}
		return result.toString();
	}
	
	public static void main(String args[]) {
		System.out.println(new CargoShip(2, 3, 4));
	}
	
}

