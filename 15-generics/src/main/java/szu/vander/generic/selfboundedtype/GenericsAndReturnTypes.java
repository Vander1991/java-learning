package szu.vander.generic.selfboundedtype;

//: generics/GenericsAndReturnTypes.java
/**
 * 
 * @author : Vander
 * @date : 2018-12-24
 * @description : 自限定泛型将产生确切的导出类作为其返回值
 */
interface GenericGetter<T extends GenericGetter<T>> {
	T get();
}

interface Getter extends GenericGetter<Getter> {
}

public class GenericsAndReturnTypes {
	void test(Getter g) {
		Getter result = g.get();
		GenericGetter gg = g.get(); // Also the base type
	}
} /// :~
