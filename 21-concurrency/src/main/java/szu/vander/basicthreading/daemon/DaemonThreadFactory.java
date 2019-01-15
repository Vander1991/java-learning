//: net/mindview/util/DaemonThreadFactory.java
package szu.vander.basicthreading.daemon;

import java.util.concurrent.*;

/**
 * 
* @author      : Vander
* @date        : 2019-01-15
* @description ： 通过编写定制的ThreadFactory可以定制由Executor创建的线程的属性（后台、优先级、名称）
 */
public class DaemonThreadFactory implements ThreadFactory {
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}
} /// :~
