package szu.vander.container.queue;

//: holding/PriorityQueueDemo.java
import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-20
* @description : 先进先出描述了最典型的队列规则，队列规则是指在给定一组队列中的元素的情况下，确定下一个弹出队列的
* 				元素的规则。先进先出声明的是下一个元素应该是等待时间最长的元素
* 				优先级队列声明一个弹出元素是最需要被处理的元素（具有最高的优先级），如果构建一个消息系统，某些消息比其他
* 				消息更重要，因而应该更快地得到处理
* 				   构造的时候可以传入Comparator来判断谁的优先级较高，当然你也可以自行实现Comparator
 */
public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++)
			priorityQueue.offer(rand.nextInt(i + 10));
		QueueDemo.printQ(priorityQueue);

		List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
		priorityQueue = new PriorityQueue<Integer>(ints);
		QueueDemo.printQ(priorityQueue);
		priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());
		priorityQueue.addAll(ints);
		QueueDemo.printQ(priorityQueue);

		String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
		List<String> strings = Arrays.asList(fact.split(""));
		PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
		QueueDemo.printQ(stringPQ);
		stringPQ = new PriorityQueue<String>(strings.size(), Collections.reverseOrder());
		stringPQ.addAll(strings);
		QueueDemo.printQ(stringPQ);

		Set<Character> charSet = new HashSet<Character>();
		for (char c : fact.toCharArray())
			charSet.add(c); // Autoboxing
		PriorityQueue<Character> characterPQ = new PriorityQueue<Character>(charSet);
		QueueDemo.printQ(characterPQ);
	}
} /*
	 * Output: 0 1 1 1 1 1 3 5 8 14 1 1 2 3 3 9 9 14 14 18 18 20 21 22 23 25 25 25
	 * 25 23 22 21 20 18 18 14 14 9 9 3 3 2 1 1 A A B C C C D D E E E F H H I I L N
	 * N O O O O S S S T T U U U W W U U U T T S S S O O O O N N L I I H H F E E E D
	 * D C C C B A A A B C D E F H I L N O S T U W
	 */// :~
