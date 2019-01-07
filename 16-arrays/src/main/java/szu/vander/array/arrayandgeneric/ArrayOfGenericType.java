package szu.vander.array.arrayandgeneric;

//: arrays/ArrayOfGenericType.java
// Arrays of generic types won't compile.

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-06
 * @description: 试图想转成T[]类型，但是类型实际上已经被擦除，这个数组没有真正持有或动态检查类型T，也就是说
 * 				如果我创建一个String[]，Java在编译期和运行时都会强制要求我只能将String对象置于该数组中
 * 				但是如果创建Object[]，我就可以将除基本类型之外的任何对象置于此数组中了 				
 */
public class ArrayOfGenericType<T> {
	T[] array; // OK

	@SuppressWarnings("unchecked")
	public ArrayOfGenericType(int size) {
		// ! array = new T[size]; // Illegal
		array = (T[]) new Object[size]; // "unchecked" Warning
	}
	// Illegal:
	// ! public <U> U[] makeArray() { return new U[10]; }
} /// :~
