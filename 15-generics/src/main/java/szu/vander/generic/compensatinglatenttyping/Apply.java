package szu.vander.generic.compensatinglatenttyping;

import static szu.vander.util.Print.print;

//: generics/Apply.java
// {main: ApplyTest}
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import szu.vander.util.SimpleQueue;

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-01
 * @description: 这里两个限制，要使用FillListed方法，Type就必须有无参构造函数，但是Java中没有任何方式可以在
 * 				编译器断言这种事情，所以这就变成了一个运行时问题。确保编译器检查的常见建议是定义一个工厂接口，它有一
 * 				个可以生成对象的方法，然后FilledList将接受这个接口而不是这个类型标记的“原生工厂”，而这样做的问
 * 				题是在FilledList中使用的所有类都必须实现这个工厂接口
 */
public class Apply {
	public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
		try {
			for (T t : seq)
				f.invoke(t, args);
		} catch (Exception e) {
			// Failures are programmer errors
			throw new RuntimeException(e);
		}
	}
}

class Shape {
	public void rotate() {
		print(this + " rotate");
	}

	public void resize(int newSize) {
		print(this + " resize " + newSize);
	}
}

class Square extends Shape {
}

class FilledList<T> extends ArrayList<T> {
	public FilledList(Class<? extends T> type, int size) {
		try {
			for (int i = 0; i < size; i++)
				// Assumes default constructor:
				add(type.newInstance());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class ApplyTest {
	public static void main(String[] args) throws Exception {
		
		List<Shape> shapes = new ArrayList<Shape>();
		for (int i = 0; i < 10; i++) {
			shapes.add(new Shape());
		}
		Apply.apply(shapes, Shape.class.getMethod("rotate"));
		Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);
		
		List<Square> squares = new ArrayList<Square>();
		for (int i = 0; i < 10; i++) {
			squares.add(new Square());
		}
		Apply.apply(squares, Shape.class.getMethod("rotate"));
		Apply.apply(squares, Shape.class.getMethod("resize", int.class), 5);

		Apply.apply(new FilledList<Shape>(Shape.class, 10), Shape.class.getMethod("rotate"));
		Apply.apply(new FilledList<Shape>(Square.class, 10), Shape.class.getMethod("rotate"));

		SimpleQueue<Shape> shapeQ = new SimpleQueue<Shape>();
		for (int i = 0; i < 5; i++) {
			shapeQ.add(new Shape());
			shapeQ.add(new Square());
		}
		Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
	}
} /* (Execute to see output) */// :~
