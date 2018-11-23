package szu.vander.exception.constructor.practice.practice22;
/**
* @author      : Vander
* @date        : 2018-11-22
* @description ： 
*/
class ConstructionException extends Exception {
	private static final long serialVersionUID = -8659028817881542428L;
}


public class FailingConstructor {

	public FailingConstructor() throws ConstructionException {
		
	}
	
	public void test() throws Exception {
		System.out.println("test()");
	}
	
	public static void main(String args[]) {
		try {
			FailingConstructor failingConstructor = new FailingConstructor();
			failingConstructor.test();
		} catch (ConstructionException e) {
			System.out.println("Construct Failed!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
