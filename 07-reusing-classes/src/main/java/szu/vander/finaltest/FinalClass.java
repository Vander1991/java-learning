package szu.vander.finaltest;

/**
 * @author : Vander Choi
 * @date : 2018-11-11
 * @description : Final类断子绝孙，final类中的所有方法都隐式指定为final，因为无法覆盖它们
 */
public class FinalClass {

	public static void main(String[] args) {
		Dinosaur n = new Dinosaur();
		n.f();
		n.i = 40;
		n.j++;
		System.out.println(n);
	}

}

class SmallBrain {
}

final class Dinosaur {
	int i = 7;
	int j = 1;
	SmallBrain x = new SmallBrain();

	// 方法都隐含加了final
	void f() {
	}
	
	public String toString() {
		return "Dinosaur.i:" + i + ",Dinosaur.j:" + j ;
	}
	
}

//! class Further extends Dinosaur {}
//error: Cannot extend final class 'Dinosaur'