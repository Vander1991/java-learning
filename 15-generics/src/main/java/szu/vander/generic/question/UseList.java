package szu.vander.generic.question;

//: generics/UseList.java
// {CompileTimeError} (Won't compile)
import java.util.*;

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-20
 * @description: 由于擦除的原因，重载方法将产生相同的类型签名
 */
public class UseList<W, T> {
//  重复定义函数f()
//	void f(List<T> v) {
//	}

	void f(List<W> v) {
	}
} /// :~
