package szu.vander.generic.erasurecompensate.exercise.exercise21;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

/**
 * 
* @author      : Vander
* @date        : 2018-12-12
* @description : 修改ClassTypeCapture.java，添加一个Map<String, Class<?>>，一个addType(String typename
* 				, Class<?>kind)方法和一个createNew(String typename)方法。createNew()将产生一个与其参数字符串
* 				相关联的类的新实例，或者产生一条错误消息。
 */
class Building {
	
	Building() {
		System.out.println("Building()");
	}
	
}

class House extends Building {
	
	House() {
		System.out.println("House()");
	}
	
}

public class ClassTypeCapture {

	private static Map<String, Class<?>> types = new HashMap<String, Class<?>>();
	
	public static void addType(String typename, Class<?> kind) {
		types.put(typename, kind);
	}
	
	public static Object createNew(String typename) {
		try {
			return types.get(typename).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		addType("Building", Building.class);
		addType("House", House.class);
		Building building = (Building) createNew("Building");
		House house = (House) createNew("House");
	}
} /*
	 * Output: true true false true
	 */// :~
