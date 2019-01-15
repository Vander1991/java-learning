package szu.vander.basicthreading.returnvalue;

import java.util.concurrent.*;
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2019-01-15
* @description ： Runnable是执行工作的独立任务，但是没有返回值，希望任务完成后返回一个值，可以实现Callable接口而不是Runnable接口
* 				JDK5中引入Callable是一种具有类型参数的泛型，它的泛型参数表示从call中返回的值，并且必须使用ExecutorService.submit
* 				方法调用它
* 				 submit方法会产生Future对象，它用Callable返回结果的特定类型进行了参数化。你可以用isDone()方法来查询Future是否已经
* 				完成，当任务完成时，它具有一个结果，你可以调用get()方法来获取该结果。也可以不用isDone()进行检查就直接调用get()
* 				在这种情况下，get()将阻塞，直至结果准备就绪。你还可以在试图调用get()来获取结果之前，先调用具有超时的get(0，或者
* 				调用isDone()来查看任务是否完成。
 */
class TaskWithResult implements Callable<String> {
	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	public String call() {
		return "result of TaskWithResult " + id;
	}
}

public class CallableDemo {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++)
			results.add(exec.submit(new TaskWithResult(i)));
		for (Future<String> fs : results)
			try {
				// get() blocks until completion:
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				System.out.println(e);
				return;
			} catch (ExecutionException e) {
				System.out.println(e);
			} finally {
				exec.shutdown();
			}
	}
} /*
	 * Output: result of TaskWithResult 0 result of TaskWithResult 1 result of
	 * TaskWithResult 2 result of TaskWithResult 3 result of TaskWithResult 4 result
	 * of TaskWithResult 5 result of TaskWithResult 6 result of TaskWithResult 7
	 * result of TaskWithResult 8 result of TaskWithResult 9
	 */// :~
