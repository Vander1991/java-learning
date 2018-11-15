package szu.vander.innerclass.insertclass;

//: innerclasses/ClassInInterface.java
// {main: ClassInInterface$Test}
/**
 * 
* @author      : Vander
* @date        : 2018-11-15
* @description : 正常情况下，接口内部不能放置任何代码。但嵌套类可以作为接口的一部分。你放到接口中的任何类都自动地是public
* 				和static的。因为类是static的，只是将嵌套类放置在接口的命名空间内，并不违反接口的规则。甚至可以在内部类中
* 				实现其外围接口
* 				 如果想要创建某些公共代码，使得他们可以被某个接口的所有不同实现所共用，那么使用接口内部的嵌套类会显得方便
 */
public interface ClassInInterface {
	void howdy();

	class Test implements ClassInInterface {
		public void howdy() {
			System.out.println("Howdy!");
		}

		public static void main(String[] args) {
			new Test().howdy();
		}
	}
} /*
	 * Output: Howdy!
	 */// :~
