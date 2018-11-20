package szu.vander.container.iterator;


//: holding/CrossContainerIteration.java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import szu.vander.container.pet.Pet;
import szu.vander.container.pet.Pets;

/**
 * 
* @author      : Vander
* @date        : 2018-11-19
* @description : 迭代器的目的就是屏蔽了具体的容器类，使用同样的方法就可以遍历并选择序列中的元素，而客户端程序员并不需要知道
* 				也不用关心底层的容器结构
* 				Iterator还可以移除由next()产生的最后一个元素，这意味着在调用remove()之前必须先调用next()
 */
public class CrossContainerIteration {
	public static void display(Iterator<Pet> it) {
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.print(p.id() + ":" + p + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayList<Pet> pets = Pets.arrayList(8);
		LinkedList<Pet> petsLL = new LinkedList<Pet>(pets);
		HashSet<Pet> petsHS = new HashSet<Pet>(pets);
		TreeSet<Pet> petsTS = new TreeSet<Pet>(pets);
		display(pets.iterator());
		display(petsLL.iterator());
		display(petsHS.iterator());
		display(petsTS.iterator());
	}
} /*
	 * Output: 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 0:Rat 1:Manx
	 * 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 4:Pug 6:Pug 3:Mutt 1:Manx
	 * 5:Cymric 7:Manx 2:Cymric 0:Rat 5:Cymric 2:Cymric 7:Manx 1:Manx 3:Mutt 6:Pug
	 * 4:Pug 0:Rat
	 */// :~
