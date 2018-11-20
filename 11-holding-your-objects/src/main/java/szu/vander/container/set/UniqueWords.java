package szu.vander.container.set;

//: holding/UniqueWords.java
import java.util.Set;
import java.util.TreeSet;

import szu.vander.util.TextFile;

/**
 * 
* @author      : Vander
* @date        : 2018-11-19
* @description : TestFile继承自List<String>，其构造器将打开文件，并根据正则表达式将其断开为单词，这个正则表达式表示“一个或多个”
* 				所产生的记过传递给TreeSet的构造器，将List中的内容添加到自身，并自动按字典排序，可以像TreeSet构造器传入
* 				String.CASE_INSENTIVE_ORDER比较器
 */
public class UniqueWords {
	public static void main(String[] args) {
		Set<String> words = new TreeSet<String>(new TextFile("src/main/java/szu/vander/container/set/SetOperations.java", "\\W+"));
		System.out.println(words);
	}
} /*
	 * Output: [A, B, C, Collections, D, E, F, G, H, HashSet, I, J, K, L, M, N,
	 * Output, Print, Set, SetOperations, String, X, Y, Z, add, addAll, added, args,
	 * class, contains, containsAll, false, from, holding, import, in, java, main,
	 * mindview, net, new, print, public, remove, removeAll, removed, set1, set2,
	 * split, static, to, true, util, void]
	 */// :~
