package szu.vander.typeinfo.classobject;

//: typeinfo/GenericClassReferences.java

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-01
 * @description: genericIntClass是泛化的Class引用，它只能赋值为其声明的类型
 */
public class GenericClassReferences {
	public static void main(String[] args) {
		Class intClass = int.class;
		Class<Integer> genericIntClass = int.class;
		genericIntClass = Integer.class; // Same thing
		intClass = double.class;
		// genericIntClass = double.class; // Illegal
	}
} /// :~
