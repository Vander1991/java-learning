package szu.vander.innerclass.upcast.practice.practice8;
/**
* @author      : Vander
* @date        : 2018-11-14
* @description ：  外部类访问不了内部类的private属性 
*/
public class Outer {

	public void ChangeInnerContent(String content) {
		//! innerContent = content;
	}
	
	class Inner {
		
		private String innerContent;
		
		Inner(String innerContent){
			this.innerContent = innerContent;
		}
		
		public String toString() {
			return innerContent;
		}
		
	}
	
}
