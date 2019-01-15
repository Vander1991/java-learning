package szu.vander.container.fill.exercise.exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import szu.vander.container.fill.usingabstract.Countries;

/**
* @author     : Vander
* @date       : 2019-01-10
* @description: 创建一个List（用ArrayList和LinkedList都尝试一下），然后用Counties来填充。对该列表排序并打印，然后将Collection.shuffle()方法重复地
* 				应用于该列表，并且每次都打印它，这样就可以看到shuffle()方法是如何每次都将列表随机打乱的了 
*/
public class Exercise1 {

	public static void main(String args[]) {
		List<String> arrayList = new ArrayList<String>(Countries.names(10));
		Collections.shuffle(arrayList);
		System.out.println(arrayList);
		Collections.shuffle(arrayList);
		System.out.println(arrayList);
		List<String> linkedList = new LinkedList<String>(Countries.names(10));
		Collections.shuffle(linkedList);
		System.out.println(linkedList);
		Collections.shuffle(linkedList);
		System.out.println(linkedList);
	}
	
}
