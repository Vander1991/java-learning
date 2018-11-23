package szu.vander.exception.constructor.practice.practice24;
/**
* @author      : Vander
* @date        : 2018-11-22
* @description ： 构造有可能会失败，一般是用两层try给套起来
*/
class ConstructionException extends Exception {
	private static final long serialVersionUID = -8659028817881542428L;
}


public class FailingConstructor {

	public FailingConstructor(boolean succeed) throws ConstructionException {
		if(!succeed) {
			throw new ConstructionException();
		}
	}
	
	public void test() throws Exception {
		System.out.println("test()");
	}
	
	public void dispose() {
		System.out.println("dispose()");
	}
	
	public static void main(String args[]) {
		FailingConstructor failingConstructor = null;
		try {
			failingConstructor = new FailingConstructor(false);
			try {
				failingConstructor.test();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				failingConstructor.dispose();
			}
		} catch (ConstructionException e) {
			System.out.println("Construct Failed!!!");
		} 

	}
	
}
