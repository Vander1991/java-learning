package szu.vander.clean;

import static szu.vander.util.Print.*;

/**
* @author      : Vander
* @date        : 2018-11-09
* @description ： 执行类的所有特定的清理动作，其顺序同生成顺序相反
* 				 最好的办法是除了内存之外，不能依赖垃圾回收器去做任何事情。如果需要进行清理，最好编写自己的清理方法，
* 				但是不要使用finalize()
*/
public class CADSystem extends Shape {

	private Circle c;
	private Triangle t;
	private Line[] lines = new Line[3];
	public CADSystem(int i) {
		super(i+1);
		for(int j = 0; j < lines.length; j++) {
			lines[j] = new Line(j, j*j);
		}
		c = new Circle(1);
		t = new Triangle(1);
		print("Combined constructor");
	}
	
	public void dispose() {
		print("CADSystem.dispose()");
		//清理的顺序与初始化的顺序相反
		t.dispose();
		c.dispose();
		for(int j = 0; j < lines.length; j++) {
			lines[j].dispose();
		}
		super.dispose();
	}
	
	public static void main(String args[]) {
		CADSystem x = new CADSystem(47);
		try {
			
		} finally {
			x.dispose();
		}
	}
	
}

class Shape {
	Shape(int i) {
		print("Shape(" + i + ")");
	}
	void dispose() {
		print("Shape dispose");
	}
}

class Circle extends Shape {
	Circle(int i) {
		super(i);
		print("Circle(" + i + ")");
	}
	void dispose() {
		print("Erasing Circle");
		super.dispose();
	}
}

class Triangle extends Shape {
	Triangle(int i) {
		super(i);
		print("Triangle(" + i + ")");
	}
	void dispose() {
		print("Erasing Triangle");
		super.dispose();
	}
}

class Line extends Shape {
	
	private int start, end;
	
	Line(int start, int end) {
		super(start);
		this.start = start;
		this.end = end;
		print("Drawing Line: " + start + "->" + end);
	}
	void dispose() {
		print("Erasing Line: " + start + "->" + end);
		super.dispose();
	}
}