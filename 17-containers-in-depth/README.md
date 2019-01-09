# 17-容器深入研究：
	前言：
		在这章节，需要掌握散列机制如何工作，使用散列容器怎样编写hashCode()和equals()方法。为什么某些容器会有不同版本的
	实现，以及怎样在它们之间做出选择
	
	完整容器的分类：
		在Java.util底下可以看到一系列类名以Abstract开头的，这些类只是部分实现了特定接口的工具。
	
	填充容器：
		Collections.nCopies创建传递给构造器的List，用单个对象的引用来填充Collection的方式，还有一种方式是就是使用
	Collection.fill，fill只能替换已经存在在List中的元素，而不能添加新元素
		可以通过构造器或Map.putAll()和Collection.addAll()方法来初始化Map和Collection。
# 总结：

	
