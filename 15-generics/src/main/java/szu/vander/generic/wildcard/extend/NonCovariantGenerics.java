package szu.vander.generic.wildcard.extend;

//: generics/NonCovariantGenerics.java
// {CompileTimeError} (Won't compile)
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-12-14
* @description : 泛型的主要目标之一是将赋值类型错误检查移到编译期来进行
* 				Apple的List在类型上不等价于Fruit的List
 */
public class NonCovariantGenerics {
  // Compile Error: incompatible types:
  //! List<Fruit> flist = new ArrayList<Apple>();
} ///:~
