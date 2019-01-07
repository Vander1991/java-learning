package szu.vander.array.arrayandgeneric;

//: arrays/ParameterizedArrayType.java

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-05
 * @description: 使用参数化方法而不适用参数化类的方便之处在于，你不必为需要应用的每种不同的类型都使用一个参数去实例化这个类，并且
 * 				你可以将其定义为静态的。当然，你不能总是选择参数化方法而不是参数化类，但参数化方法应该成为首选
 */
class ClassParameter<T> {
	public T[] f(T[] arg) {
		return arg;
	}
}

class MethodParameter {
	public static <T> T[] f(T[] arg) {
		return arg;
	}
}

public class ParameterizedArrayType {
	public static void main(String[] args) {
		Integer[] ints = { 1, 2, 3, 4, 5 };
		Double[] doubles = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Integer[] ints2 = new ClassParameter<Integer>().f(ints);
		Double[] doubles2 = new ClassParameter<Double>().f(doubles);
		ints2 = MethodParameter.f(ints);
		doubles2 = MethodParameter.f(doubles);
	}
} /// :~
