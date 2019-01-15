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
		享元模式（蝇量模式）：当一个类有许多实例，而这些实例能背同一个方法控制时，我们就可以使用享元模式。
			优点：减少运行时对象实例的个数，节省内存，将许多虚拟对象的状态集中管理
			缺点：一旦你实现了它，那么单个逻辑实例将无法拥有独立而不同的行为。
	
	可选操作：
		Collections.unmodifiableList产生不可修改的列表
		Arrays.asList方法则返回尺寸固定的list
		如果返回的用Collection.addAll包起来了，这样就允许使用所有方法的普通容器
	
	List：
		LinkedList是一个双向链表
	
	Set和存储顺序：
		当创建自己的类型时，要意识到Set需要一种方式来维护存储顺序，而存储顺序如何维护，则是在Set的不同实现之间会有所变化。
		Set：存入Set的每个元素必须是唯一的，Set不保存重复元素。加入Set的元素必须定义equals方法以确保对象的唯一性，Set
		和Collection有完全一样的接口。Set接口不保证维护元素的次序。
		HashSet(首选)：为快速查找而设计的Set。存入HashSet的元素必须定义hashCode()
		TreeSet：保持次序的Set，底层为树结构。使用它可以从Set中提取有序的序列。元素必须实现Comparable接口
		LinkedHashSet：具有HashSet的查询速度，且内部使用链表维护元素的顺序（插入的顺序）。于是在使用迭代器遍历Set时，
		结果会按元素插入的次序显示。元素也必须定义hashCode()方法。
		散列存储和树形村塾都创建一个equals方法，但是hashCode()只有在这个类将会被置于HashSet或者LinkedHashSet中时才
		必须，但是良好的编程风格而言，应该在覆盖equals方法的时候同时覆盖hashCode()方法。
	
# 总结：

	
