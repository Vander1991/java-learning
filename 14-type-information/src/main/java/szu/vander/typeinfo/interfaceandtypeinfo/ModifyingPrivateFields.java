package szu.vander.typeinfo.interfaceandtypeinfo;

//: typeinfo/ModifyingPrivateFields.java
import java.lang.reflect.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-09
* @description : 虽然这样依然无法改变field被访问的命运，但是使用了final实际上遭遇修改时是安全的，运行时系统会在不抛异常的情况下
* 				接受任何修改尝试，但是实际上不会发生修改
 */
class WithPrivateFinalField {
	private final int i = 1;
	private final String s = "I'm totally safe";
	private String s2 = "Am I safe?";

	public String toString() {
		return "i = " + i + ", " + s + ", " + s2;
	}
}

public class ModifyingPrivateFields {
	public static void main(String[] args) throws Exception {
		WithPrivateFinalField pf = new WithPrivateFinalField();
		System.out.println(pf);
		Field f = pf.getClass().getDeclaredField("i");
		f.setAccessible(true);
		System.out.println("f.getInt(pf): " + f.getInt(pf));
		f.setInt(pf, 47);
		System.out.println(pf);
		f = pf.getClass().getDeclaredField("s");
		f.setAccessible(true);
		System.out.println("f.get(pf): " + f.get(pf));
		f.set(pf, "No, you're not!");
		System.out.println(pf);
		f = pf.getClass().getDeclaredField("s2");
		f.setAccessible(true);
		System.out.println("f.get(pf): " + f.get(pf));
		f.set(pf, "No, you're not!");
		System.out.println(pf);
	}
} /*
	 * Output: i = 1, I'm totally safe, Am I safe? f.getInt(pf): 1 i = 47, I'm
	 * totally safe, Am I safe? f.get(pf): I'm totally safe i = 47, I'm totally
	 * safe, Am I safe? f.get(pf): Am I safe? i = 47, I'm totally safe, No, you're
	 * not!
	 */// :~
