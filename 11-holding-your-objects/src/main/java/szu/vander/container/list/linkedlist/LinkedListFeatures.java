package szu.vander.container.list.linkedlist;

//: holding/LinkedListFeatures.java
import static szu.vander.util.Printer.print;

import java.util.LinkedList;

import szu.vander.container.pet.Hamster;
import szu.vander.container.pet.Pet;
import szu.vander.container.pet.Pets;
import szu.vander.container.pet.Rat;

/**
 * 
* @author      : Vander
* @date        : 2018-11-19
* @description : LinkedList在List的中间插入和移除比ArrayList更有效，但在随机访问操作略逊色
* 				LinkedList还添加了可以使其用作栈、队列或双端队列的方法
**/
public class LinkedListFeatures {
	public static void main(String[] args) {
		LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
		print(pets);
		// Identical:
		print("pets.getFirst(): " + pets.getFirst());
		print("pets.element(): " + pets.element());
		// Only differs in empty-list behavior:
		print("pets.peek(): " + pets.peek());
		// Identical; remove and return the first element:
		print("pets.remove(): " + pets.remove());
		print("pets.removeFirst(): " + pets.removeFirst());
		// Only differs in empty-list behavior:
		print("pets.poll(): " + pets.poll());
		print(pets);
		pets.addFirst(new Rat());
		print("After addFirst(): " + pets);
		// offer、add、addLast都是添加到末尾
		pets.offer(Pets.randomPet());
		print("After offer(): " + pets);
		pets.add(Pets.randomPet());
		print("After add(): " + pets);
		pets.addLast(new Hamster());
		print("After addLast(): " + pets);
		print("pets.removeLast(): " + pets.removeLast());
	}
} /*
	 * Output: [Rat, Manx, Cymric, Mutt, Pug] pets.getFirst(): Rat pets.element():
	 * Rat pets.peek(): Rat pets.remove(): Rat pets.removeFirst(): Manx pets.poll():
	 * Cymric [Mutt, Pug] After addFirst(): [Rat, Mutt, Pug] After offer(): [Rat,
	 * Mutt, Pug, Cymric] After add(): [Rat, Mutt, Pug, Cymric, Pug] After
	 * addLast(): [Rat, Mutt, Pug, Cymric, Pug, Hamster] pets.removeLast(): Hamster
	 */// :~
