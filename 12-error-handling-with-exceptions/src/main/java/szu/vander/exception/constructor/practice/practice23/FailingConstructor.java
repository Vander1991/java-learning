package szu.vander.exception.constructor.practice.practice23;
/**
* @author      : Vander
* @date        : 2018-11-22
* @description ： 
*/
class ConstructionException extends Exception {
	private static final long serialVersionUID = -8659028817881542428L;
}

class WithDispose {
	private final int id;
	
	public WithDispose(int id) {
		System.out.println("Construct WithDispose" + id);
		this.id = id;
	}
	
	void dispose() {
		System.out.println("WithDispose.dispose():" + id);
	}
	
}

public class FailingConstructor {

	private WithDispose dispose1, dispose2;
	
	public FailingConstructor(boolean succeed) throws ConstructionException {
		try {
			dispose1 = new WithDispose(1);
			if(!succeed) {
				throw new ConstructionException();
			}
		} catch (ConstructionException e) {
			System.out.println("Construct failed");
			dispose1.dispose();
			throw e;
		} 
		dispose2 = new WithDispose(2);
	}
	
	public void test() throws Exception {
		System.out.println("test()");
	}
	
	public static void main(String args[]) {
		try {
			FailingConstructor failingConstructor = new FailingConstructor(true);
			failingConstructor.test();
		} catch (ConstructionException e) {
			System.out.println("Construct Failed!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
