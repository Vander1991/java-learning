package szu.vander.typeinfo.classobject;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-01
 * @description: 将通配符？与extends结合,来创建一个范围
 */
public class BoundedClassReferences {
	public static void main(String[] args) {
		Class<? extends Number> bounded = int.class;
		bounded = double.class;
		bounded = Number.class;
		// Or anything else derived from Number.
	}
} /// :~
