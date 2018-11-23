package szu.vander.init;
/**
* @author : Vander Choi
* @date : 2018-11-05
* @description :
*/
public class StaticTest {

	public static void main(String[] args) {
		Base sub = new Sub();
		sub = (Base)new Sub();
	}

}

class Base {
	
	static {
		System.out.println("static Base");
	}

	Base() {
		System.out.println("Base()");
	}
	
}

class Sub extends Base {
	
	static {
		System.out.println("static Sub");
	}

	Sub() {
		System.out.println("Sub()");
	}
	
}
