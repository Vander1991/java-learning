package szu.vander.resourceshare.error;

//: concurrency/EvenChecker.java
import java.util.concurrent.*;

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-19
 * @description: 分别启动了10个线程来使用generator这个资源，每个线程都运行run方法，刚开始执行的几个线程
 * 				都获取到了generator的状态不是canceled，所以进入循环，然后进入循环的这几个线程去执行generator的next方法
 * 				假设第一个线程加到3的时候，第二个线程过来正好完成了generator的next将currentEvenValue加到了5，然后此时
 * 				第二个线程判断 val%2 != 0 这个条件就成立了，所以就出现了not even，然后将generator给cancel掉
 * 				可能会有好几个线程间都会出现这种情况，所以会打印出几个not even
 */
public class EvenChecker implements Runnable {
	private IntGenerator generator;
	private final int id;

	public EvenChecker(IntGenerator g, int ident) {
		generator = g;
		id = ident;
	}

	public void run() {
		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(val + " not even!");
				generator.cancel(); // Cancels all EvenCheckers
			}
		}
	}

	// Test any type of IntGenerator:
	public static void test(IntGenerator gp, int count) {
		System.out.println("Press Control-C to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++)
			exec.execute(new EvenChecker(gp, i));
		exec.shutdown();
	}

	// Default value for count:
	public static void test(IntGenerator gp) {
		test(gp, 10);
	}
} /// :~
