//: concurrency/CriticalSection.java
// Synchronizing blocks instead of entire methods. Also
// demonstrates protection of a non-thread-safe class
// with a thread-safe one.
package szu.vander.resourceshare.criticalsection;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2019-02-05
* @description : Pair虽然不是线程安全的，但是它被PairManager包装起来就变成安全的了，PairManager使用了模板方法模式，
* 				increase方法被子类所定义，PairManipulator负责将PairManager包装成线程，然后由Executor来驱动，
* 				PairChecker负责检查Pair中的x，y是否是相同的值。
* 				 PairChecker的检查频率，PM2会比PM1多得多，大概是因为pc1跟pm1是竞争关系，pc1要等store完了才能进行检查，
* 				而，pc2则不用等pm2的store。PairManager1.increment()也不会比PairManager2.increment()
* 				执行的次数多，因为在PairManager2同步控制的是PairManager1同步控制的一部分，PairManager2同步控制
* 				的部分没有耗时较长的store()
 */
class Pair { // Not thread-safe
	private int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair() {
		this(0, 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void incrementX() {
		x++;
	}

	public void incrementY() {
		y++;
	}

	public String toString() {
		return "x: " + x + ", y: " + y;
	}

	@SuppressWarnings("serial")
	public class PairValuesNotEqualException extends RuntimeException {
		public PairValuesNotEqualException() {
			super("Pair values not equal: " + Pair.this);
		}
	}

	// Arbitrary invariant -- both variables must be equal:
	public void checkState() {
		if (x != y)
			throw new PairValuesNotEqualException();
	}
}

// Protect a Pair inside a thread-safe class:
abstract class PairManager {
	AtomicInteger checkCounter = new AtomicInteger(0);
	protected Pair p = new Pair();
	private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

	public synchronized Pair getPair() {
		// Make a copy to keep the original safe:
		return new Pair(p.getX(), p.getY());
	}

	// Assume this is a time consuming operation
	protected void store(Pair p) {
		storage.add(p);
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException ignore) {
		}
	}

	public abstract void increment();
}

// Synchronize the entire method:
class PairManagerImpl1 extends PairManager {
	public synchronized void increment() {
		p.incrementX();
		p.incrementY();
		store(getPair());
	}
}

// Use a critical section:
class PairManagerImpl2 extends PairManager {
	public void increment() {
		Pair temp;
		synchronized (this) {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}
}

class PairManipulator implements Runnable {
	private PairManager pm;

	public PairManipulator(PairManager pm) {
		this.pm = pm;
	}

	public void run() {
		while (true)
			pm.increment();
	}

	public String toString() {
		return "Pair: " + pm.getPair() + " checkCounter = " + pm.checkCounter.get();
	}
}

class PairChecker implements Runnable {
	private PairManager pm;

	public PairChecker(PairManager pm) {
		this.pm = pm;
	}

	public void run() {
		while (true) {
			pm.checkCounter.incrementAndGet();
			pm.getPair().checkState();
		}
	}
}

public class CriticalSection {
	// Test the two different approaches:
	static void testApproaches(PairManager pman1, PairManager pman2) {
		ExecutorService exec = Executors.newCachedThreadPool();
		PairManipulator pm1 = new PairManipulator(pman1), pm2 = new PairManipulator(pman2);
		PairChecker pcheck1 = new PairChecker(pman1), pcheck2 = new PairChecker(pman2);
		exec.execute(pm1);
		exec.execute(pm2);
		exec.execute(pcheck1);
		exec.execute(pcheck2);
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("Sleep interrupted");
		}
		System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
		System.exit(0);
	}

	public static void main(String[] args) {
		PairManager pman1 = new PairManagerImpl1(), pman2 = new PairManagerImpl2();
		testApproaches(pman1, pman2);
	}
} /*
	 * Output: (Sample) pm1: Pair: x: 15, y: 15 checkCounter = 272565 pm2: Pair: x:
	 * 16, y: 16 checkCounter = 3956974
	 */// :~
