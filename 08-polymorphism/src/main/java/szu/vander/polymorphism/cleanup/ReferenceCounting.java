package szu.vander.polymorphism.cleanup;

import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-12
* @description ：  成员对象中存在于其他一个或多个对象共享的情况，销毁的过程就变得复杂了，在这种情况下，也许必需使用引用
* 				计数来跟踪仍旧访问着共享对象的对象数量了
 */
class Shared {
	// 跟踪有多少引用此共享的对象
	private int refcount = 0;
	// 计算有多少个Shared的实例
	private static long counter = 0;
	// 定义成final是希望id不能被改变
	private final long id = counter++;

	public Shared() {
		print("Creating " + this);
	}

	public void addRef() {
		refcount++;
	}

	protected void dispose() {
		if (--refcount == 0)
			print("Disposing " + this);
	}

	public String toString() {
		return "Shared " + id;
	}
}

class Composing {
	private Shared shared;
	private static long counter = 0;
	private final long id = counter++;

	public Composing(Shared shared) {
		print("Creating " + this);
		this.shared = shared;
		this.shared.addRef();
	}

	protected void dispose() {
		print("disposing " + this);
		shared.dispose();
	}

	public String toString() {
		return "Composing " + id;
	}
}

public class ReferenceCounting {
	public static void main(String[] args) {
		Shared shared1 = new Shared();
		Shared shared2 = new Shared();
		Composing[] composing = { new Composing(shared1), new Composing(shared1), new Composing(shared1),
				new Composing(shared2), new Composing(shared2) };
		for (Composing c : composing)
			c.dispose();
	}
} /*
	 * Output: Creating Shared 0 Creating Composing 0 Creating Composing 1 Creating
	 * Composing 2 Creating Composing 3 Creating Composing 4 disposing Composing 0
	 * disposing Composing 1 disposing Composing 2 disposing Composing 3 disposing
	 * Composing 4 Disposing Shared 0
	 */// :~
