//: polymorphism/Sandwich.java
// Order of constructor calls.
package szu.vander.polymorphism.construtor;

import static szu.vander.util.Printer.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-12
* @description ：  基类的构造器总是在导出类的构造过程中被调用，而且按照继承层次逐渐向上链接，以使每个基类的构造器都能得到
* 				 调用，构造器有一项特殊任务：检查对象是否能被正确地构造。导出类只能访问它自己的成员，不能访问基类的（基类
* 				成员通常是private类型）只有基类构造器才有权限去访问自己的元素。因此必须令所有构造器都得到调用，否则就不能
* 				正确构造完整对象。
* 				先构造基类对象-》再初始化自己的field—》再调用自己的构造函数
 */
class Meal {
  Meal() { print("Meal()"); }
}

class Bread {
  Bread() { print("Bread()"); }
}

class Cheese {
  Cheese() { print("Cheese()"); }
}

class Lettuce {
  Lettuce() { print("Lettuce()"); }
}

class Lunch extends Meal {
  Lunch() { print("Lunch()"); }
}

class PortableLunch extends Lunch {
  PortableLunch() { print("PortableLunch()");}
}

public class Sandwich extends PortableLunch {
  private Bread b = new Bread();
  private Cheese c = new Cheese();
  private Lettuce l = new Lettuce();
  public Sandwich() { print("Sandwich()"); }
  public static void main(String[] args) {
    new Sandwich();
  }
} 
/* Output:
Meal()
Lunch()
PortableLunch()
Bread()
Cheese()
Lettuce()
Sandwich()
*///:~
