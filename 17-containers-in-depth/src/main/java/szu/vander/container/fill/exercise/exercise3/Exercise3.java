package szu.vander.container.fill.exercise.exercise3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import szu.vander.container.fill.usingabstract.Countries;

/**
* @author     : Vander
* @date       : 2019-01-10
* @description: 使用Countries，用同样的数据多次填充Set，然后验证此Set中没有重复的元素。使用HashSet、LinkedHashSet和TreeSet做此测试 
*/
public class Exercise3 {

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>(Countries.names(10));
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>(Countries.names(10));
		TreeSet<String> treeSet = new TreeSet<String>(Countries.names(10));
		System.out.println("HashSet：" + hashSet);
		System.out.println("LinkedHashSet：" + linkedHashSet);
		System.out.println("TreeSet：" + treeSet);
	}

}
