package szu.vander.generic.question;

//: generics/ClassCasting.java
import java.io.*;
import java.util.*;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-18
 * @description: 为了解决刚NeedCasting.java中的情况，JDK5引入的新的转型形式，通过泛型类来转型
 */
public class ClassCasting {
	@SuppressWarnings("unchecked")
	public void f(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
		// Won't Compile:
		// List<Widget> lw1 =
		// List<Widget>.class.cast(in.readObject());
		List<Widget> lw2 = List.class.cast(in.readObject());
	}
} /// :~
