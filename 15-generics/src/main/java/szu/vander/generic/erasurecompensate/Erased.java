package szu.vander.generic.erasurecompensate;

//: generics/Erased.java
// {CompileTimeError} (Won't compile)

/**
 * 
* @author      : Vander
* @date        : 2018-12-12
* @description : 泛型不能使用instanceof 不能new 不能转型
 */
public class Erased<T> {
  private final int SIZE = 100;
  public static void f(Object arg) {
//    if(arg instanceof T) {}          // Error
//    T var = new T();                 // Error
//    T[] array = new T[SIZE];         // Error
//    T[] array = (T)new Object[SIZE]; // Unchecked warning
  }
} ///:~
