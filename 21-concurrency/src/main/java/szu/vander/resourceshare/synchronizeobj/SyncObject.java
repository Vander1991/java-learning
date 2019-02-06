package szu.vander.resourceshare.synchronizeobj;

import static szu.vander.util.Print.*;

/**
 * 
* @author      : Vander
* @date        : 2019-02-06
* @description : 同步对象是每new一个对象，都能给一个线程执行。这里会看到f()、g()间隔运行。
 */
class DualSynch {
	private Object syncObject = new Object();

	public synchronized void f() {
		for (int i = 0; i < 5; i++) {
			print("f()");
			Thread.yield();
		}
	}

	public void g() {
		synchronized (syncObject) {
			for (int i = 0; i < 5; i++) {
				print("g()");
				Thread.yield();
			}
		}
	}
}

public class SyncObject {
	public static void main(String[] args) {
		final DualSynch ds = new DualSynch();
		new Thread() {
			public void run() {
				ds.f();
			}
		}.start();
		ds.g();
	}
} /*
	 * Output: (Sample) g() f() g() f() g() f() g() f() g() f()
	 */// :~
