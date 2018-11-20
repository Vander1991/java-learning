package szu.vander.container.queue;

//: holding/QueueDemo.java
// Upcasting to a Queue from a LinkedList.
import java.util.*;
/**
 * 
* @author      : Vander
* @date        : 2018-11-20
* @description : 队列是一个典型的先进先出（FIFO）的容器。队列常被当成一种可靠的将对象从程序的某个区域传输到另一个区域的
* 				途径。队列在并发编程特别重要，因为它们可以安全地将对象从一个任务传输给另一个任务
* 				offer()入队
* 				peek()、element()不移除情况下返回队头，peek在队列为空是返回null、element队列为空时抛异常
* 				poll()、remove()移除并返回队头，poll队列为空是返回null、element队列为空时抛异常
* 				Queue接口窄化了对linkedList的方法的访问权限，以使得只有恰当的方法才可以使用
 */
public class QueueDemo {
	public static void printQ(Queue queue) {
		while (queue.peek() != null)
			System.out.print(queue.remove() + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++)
			queue.offer(rand.nextInt(i + 10));
		printQ(queue);
		Queue<Character> qc = new LinkedList<Character>();
		for (char c : "Brontosaurus".toCharArray())
			qc.offer(c);
		printQ(qc);
	}
} /*
	 * Output: 8 1 1 1 5 14 3 1 0 1 B r o n t o s a u r u s
	 */// :~
