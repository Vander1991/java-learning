package szu.vander.exception.finallyclean.drawback;

//: exceptions/ExceptionSilencer.java

/**
 * 
* @author      : Vander
* @date        : 2018-11-21
* @description : 这样也能丢失异常
 */
public class ExceptionSilencer {
  public static void main(String[] args) {
    try {
      throw new RuntimeException();
    } finally {
      // Using 'return' inside the finally block
      // will silence any thrown exception.
      return;
    }
  }
} ///:~
