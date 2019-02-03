package szu.vander.resourceshare.atomicityandvolatility;

//: concurrency/AtomicityTest.java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-20
 * @description: 虽然return i是原子性操作，但是缺少同步使得其数值可以在处于不稳定的中间状态时被读取
 * 				由于i也不是volatile的，因此还存在可视性的问题。getValue()和evenIncrement()必须是synchronized
 * 				诸如此类问题，应该直接考虑Brian的同步原则。
 * 				 简单解释就是，虽然evenIncrement是加了锁的，但是读取的时候（也就是getValue）没有加锁导致获取数值的时候有机会会
 * 				获取到只递增了一次的状态。
 */
public class AtomicityTest implements Runnable {
	private int i = 0;

	public int getValue() {
		return i;
	}

	private synchronized void evenIncrement() {
		i++;
		i++;
	}

	public void run() {
		while (true)
			evenIncrement();
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		exec.execute(at);
		while (true) {
			int val = at.getValue();
			if (val % 2 != 0) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}
} /*
	 * Output: (Sample) 191583767
	 */// :~
