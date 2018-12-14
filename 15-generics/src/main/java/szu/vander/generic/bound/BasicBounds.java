package szu.vander.generic.bound;

//: generics/BasicBounds.java

/**
 * 
* @author      : Vander
* @date        : 2018-12-14
* @description : extends关键字在泛型边界上下文环境中和在普通情况下所具有的意义是完全不同的
 */
interface HasColor {
	java.awt.Color getColor();
}

class Colored<T extends HasColor> {
	T item;

	Colored(T item) {
		this.item = item;
	}

	T getItem() {
		return item;
	}

	// The bound allows you to call a method:
	java.awt.Color color() {
		return item.getColor();
	}
}

class Dimension {
	public int x, y, z;
}

// This won't work -- class must be first, then interfaces:
// class ColoredDimension<T extends HasColor & Dimension> {

// Multiple bounds:
class ColoredDimension<T extends Dimension & HasColor> {
	T item;

	ColoredDimension(T item) {
		this.item = item;
	}

	T getItem() {
		return item;
	}

	java.awt.Color color() {
		return item.getColor();
	}

	int getX() {
		return item.x;
	}

	int getY() {
		return item.y;
	}

	int getZ() {
		return item.z;
	}
}

interface Weight {
	int weight();
}

// As with inheritance, you can have only one
// concrete class but multiple interfaces:
class Solid<T extends Dimension & HasColor & Weight> {
	T item;

	Solid(T item) {
		this.item = item;
	}

	T getItem() {
		return item;
	}

	java.awt.Color color() {
		return item.getColor();
	}

	int getX() {
		return item.x;
	}

	int getY() {
		return item.y;
	}

	int getZ() {
		return item.z;
	}

	int weight() {
		return item.weight();
	}
}

class Bounded extends Dimension implements HasColor, Weight {
	public java.awt.Color getColor() {
		return null;
	}

	public int weight() {
		return 0;
	}
}

public class BasicBounds {
	public static void main(String[] args) {
		Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
		solid.color();
		solid.getY();
		solid.weight();
	}
} /// :~
