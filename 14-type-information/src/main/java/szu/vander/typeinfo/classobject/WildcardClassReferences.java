package szu.vander.typeinfo.classobject;

//: typeinfo/WildcardClassReferences.java

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-01
 * @description: 使用通配符？来放松泛型类引用的限制
 */
public class WildcardClassReferences {
	public static void main(String[] args) {
		Class<?> intClass = int.class;
		intClass = double.class;
	}
} /// :~
