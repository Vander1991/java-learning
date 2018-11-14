package szu.vander.innerclass.upcast.practice.practice7;
/**
* @author      : Vander
* @date        : 2018-11-14
* @description ：  内部类具有外围对象访问权，并且可以改变外围对象的属性
*/
public class Outer {

	private String content;
	
	private String getContent() {
		return content;
	}
	
	public Outer(String content) {
		this.content = content;
	}
	
	class Inner {
		public void changeContent(String content) {
			System.out.println("Current Content: " + getContent());
			Outer.this.content = content;
			System.out.println("Changed Content: " + getContent());
		}
		
		public void testInner() {
			Inner inner = new Inner();
			inner.changeContent("abc");
		}
		
	}
	
	public static void main(String args[]) {
		Outer outer = new Outer("1234");
		outer.new Inner().testInner();
	}
	
}
