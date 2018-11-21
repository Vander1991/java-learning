package szu.vander.exception.myexception.practice.practice5;

/**
 * @author : Vander
 * @date : 2018-11-20
 * @description ：
 */
public class Practice5 {

	private static int[] intArr = new int[2];
	static int x = 5;

	public static void main(String[] args) {
		while (true) {
			try {
				intArr[x] = 1;
				System.out.println("调用成功：" + intArr[x]);
				break;
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				x--;
			} finally {
				System.out.println("Are we done yet?");
			}
		}
		System.out.println("Now, we're done.");
	}

}
