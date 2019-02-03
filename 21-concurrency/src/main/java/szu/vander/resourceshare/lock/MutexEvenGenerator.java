package szu.vander.resourceshare.lock;

//: concurrency/MutexEvenGenerator.java
// Preventing thread collisions with mutexes.
// {RunByHand}
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import szu.vander.resourceshare.error.EvenChecker;
import szu.vander.resourceshare.error.IntGenerator;

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-23
 * @description: 使用锁来重新实现，Mutex-互斥
 * 				添加了一个被互斥调用的锁，并使用lock()和unlock()方法在next()内创建了临界资源。如果在使用synchronized关键字时，
 * 				某些事物失败了，会直接抛出异常，这样就没机会去做任何清理工作，以维护系统使其良好地运行，使用了显式地Lock对象，就可以使用
 * 				finally字句将系统维护在正确的状态了。
 */
public class MutexEvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;
	private Lock lock = new ReentrantLock();

	public int next() {
		lock.lock();
		try {
			++currentEvenValue;
			Thread.yield(); // Cause failure faster
			++currentEvenValue;
			return currentEvenValue;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		EvenChecker.test(new MutexEvenGenerator());
	}
} /// :~
