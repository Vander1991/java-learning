package szu.vander.exception.discussion.practice.practice27;
/**
* @author      : Vander
* @date        : 2018-11-23
* @description ：  编写能产生并能捕获ArrayIndexOutOfBoundsException，并将其转换为RuntimeException 
*/
class MakeException {
	
	private int[] intArr = new int[5];
	
	public void makeOutOfBoundsException() throws ArrayIndexOutOfBoundsException {
		for(int i=0; i<intArr.length+1; i++) {
			intArr[i] = i;
		}
	}
}

public class Practice27 {

	public static void main(String args[]) {
		MakeException makeException = new MakeException();
		makeException.makeOutOfBoundsException();
	}
	
}
