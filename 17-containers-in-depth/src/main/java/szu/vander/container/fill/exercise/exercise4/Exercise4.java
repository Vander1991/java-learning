package szu.vander.container.fill.exercise.exercise4;

import java.util.TreeSet;

/**
* @author     : Vander
* @date       : 2019-01-13
* @description: 创建一个Collection初始化器，它将打开一个文件，并用TextFile将其断开为单词，然后将这些单词作为所产生的Collection的初始化源
* 				使用，演示它是如何工作的
*/
public class Exercise4 {

	public static void main(String[] args) {
		TextFile textFile = new TextFile("src/main/java/szu/vander/container/fill/exercise/exercise4/Exercise4.java", "\\W+");
		System.out.println("textFile：" + textFile);
		TreeSet<String> treeSet = new TreeSet<String>(textFile);
		System.out.println("treeSet：" + treeSet);
	}

}
