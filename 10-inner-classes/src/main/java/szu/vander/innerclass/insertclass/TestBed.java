package szu.vander.innerclass.insertclass;

//: innerclasses/TestBed.java
// Putting test code in a nested class.
// {main: TestBed$Tester}
/**
 * 
* @author      : Vander
* @date        : 2018-11-15
* @description : 每个类都写一个main()方法，用来测试这个类，这样做的缺点有一个，就是必须带着那些已编译过的额外代码，
* 				如果觉得麻烦的话可以用嵌套类放置测试代码，这生成一个独立的类TestBed$Tester
* 				（使用java TestBed$Tester运行即可），发布版本的时候把这个class文件删了就好了
 */				
public class TestBed {
	public void f() {
		System.out.println("f()");
	}

	public static class Tester {
		public static void main(String[] args) {
			TestBed t = new TestBed();
			t.f();
		}
	}
} /*
	 * Output: f()
	 */// :~
