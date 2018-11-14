package szu.vander.innerclass.linkouterclass;

/**
* @author      : Vander
* @date        : 2018-11-14
* @description ：  
*/
public class Practice2 {

	public static void main(String args[]) {
		Outer.Inner inner = new Outer("test1").getInner();
		Outer outer = new Outer("test2");
		Outer.Inner inner2 = outer.new Inner();
		System.out.println(inner2);
		System.out.println(inner);
	}
	
}

class Outer {
	
	private String content;
	
	public Outer(String content) {
		this.content = content;
	}
	
	public Inner getInner() {
		return new Inner();
	}
	
	class Inner {
		public String toString() {
			return content;
		}
	}
}