//: net/mindview/util/DaemonThreadPoolExecutor.java
package szu.vander.basicthreading.daemon;

import java.util.concurrent.*;

/**
 * 
* @author      : Vander
* @date        : 2019-01-16
* @description ：每个静态的ExecutorService创建方法都被重载为接收一个ThreadFactory对象，而这个对象将被用来创建新的线程
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
	public DaemonThreadPoolExecutor() {
		super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
	}
} /// :~
