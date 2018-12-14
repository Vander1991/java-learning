package szu.vander.generic.erasedscrect;

//: generics/LostInformation.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-11
* @description : 根据JDK文档的描述，Class.getTypeParameters()将“返回一个TypeVariable对象数组，表示有泛型声明所声明
* 				的类型参数... ...”
 */
class Frob {
}

// 
class Fnorkle {
}

// 夸克
class Quark<Q> {
}

// 颗粒
class Particle<POSITION, MOMENTUM> {
}

public class LostInformation {
	public static void main(String[] args) {
		List<Frob> list = new ArrayList<Frob>();
		Map<Frob, Fnorkle> map = new HashMap<Frob, Fnorkle>();
		Quark<Fnorkle> quark = new Quark<Fnorkle>();
		Particle<Long, Double> p = new Particle<Long, Double>();
		System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
	}
} /*
	 * Output: [E] [K, V] [Q] [POSITION, MOMENTUM]
	 */// :~
