package szu.vander.generic.question.exercise.exercise30;

/**
 * 
 * @author : Vander
 * @date : 2018-12-17
 * @description :
 *              为每一种基本类型的包装器类型都创建一个Holder，并展示自动包装和自动拆包机制对每个实例的set()和get()方法都起作用
 */
class Holder<T> {
	private T a;

	public Holder(T a) {
		this.a = a;
	}

	public void set(T a) {
		this.a = a;
	}

	public T get() {
		return a;
	}
}

public class Exercise30 {

	public static void main(String[] args) {
		Holder<Character> charHolder = new Holder<Character>('a');
		charHolder.set('b');
		char b = charHolder.get();
		System.out.println('b' == b);
	}

}
