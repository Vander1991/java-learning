package szu.vander.resourceshare.atomicityandvolatility;

//: concurrency/SerialNumberChecker.java
// Operations that may seem safe are not,
// when threads are present.
// {Args: 4}
import java.util.concurrent.*;

// Reuses storage so we don't run out of memory:
/**
 * 
 * @author     : Vander
 * @date       : 2019-01-20
 * @description: 通过创建多个任务来竞争序列数，即多个线程同时递增生成序列数，会得到重复的序列数。
 * 				对基本类型的读取和赋值操作被任务时安全的原子性操作。但是正如在这个例子中看到的，
 * 				当对象处于不稳定状态时，仍旧有可能使用原子性操作来访问它们，对这个问题作出的假设是棘手的。
 * 				所以最明智的做法还是遵循Brian的同步规则。
 */
class CircularSet {
	private int[] array;
	private int len;
	private int index = 0;

	public CircularSet(int size) {
		array = new int[size];
		len = size;
		// Initialize to a value not produced
		// by the SerialNumberGenerator:
		for (int i = 0; i < size; i++)
			array[i] = -1;
	}

	public synchronized void add(int i) {
		array[index] = i;
		// Wrap index and write over old elements:
		index = ++index % len;
	}

	public synchronized boolean contains(int val) {
		for (int i = 0; i < len; i++)
			if (array[i] == val)
				return true;
		return false;
	}
}

public class SerialNumberChecker {
	private static final int SIZE = 10;
	// 使用此Set不会一直消耗内存
	private static CircularSet serials = new CircularSet(1000);
	private static ExecutorService exec = Executors.newCachedThreadPool();

	static class SerialChecker implements Runnable {
		public void run() {
			while (true) {
				int serial = SerialNumberGenerator.nextSerialNumber();
				if (serials.contains(serial)) {
					System.out.println("Duplicate: " + serial);
					System.exit(0);
				}
				serials.add(serial);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < SIZE; i++)
			exec.execute(new SerialChecker());
		// Stop after n seconds if there's an argument:
		if (args.length > 0) {
			TimeUnit.SECONDS.sleep(new Integer(args[0]));
			System.out.println("No duplicates detected");
			System.exit(0);
		}
	}
} /*
	 * Output: (Sample) Duplicate: 8468656
	 */// :~
