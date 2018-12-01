package szu.vander.typeinfo.classobject;

//: typeinfo/ClassCasts.java

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-01
 * @description: 使用Class引用来转型
 * 				这个语法看似没用，但是在某些场景：例如，编写泛型代码时可能会用到
 */
class Building {
}

class House extends Building {
}

public class ClassCasts {
	public static void main(String[] args) {
		Building b = new House();
		
		Class<House> houseType = House.class;
		House h = houseType.cast(b);
		
		h = (House) b; // ... or just do this.
	}
} /// :~
