# 11-持有对象：
		Java中有多种保存对象引用的方式，数组就是其中一种，但是由于数组是固定大小的，所以用起来
	不方便，Java中有一套完整的容器类来解决这个问题，其中基本类型：List、Set、Queue、Map。
	Java类库中使用Collection这个名字来指代该类库的一个特殊子集，所以一般使用容器称呼它们
		基本概念：
		1、Collection：一个独立元素的序列，List必须按照插入顺序保存元素，Set不能有重复元素、
		Queue按照排队规则来确定对象产生的顺序
		2、Map：一组成对的“键值对“对象，允许使用键来找值
		List
			ArrayList和LinkedList，都是按照插入的顺序保存元素
			ArrayList擅长随机访问元素，但是中间插入和移除元素时较慢
			LinkedList通过代价较低的List中间进行插入和删除操作，提供了优化的顺序访问，
			LinkedLish在随机访问方面相对较慢，但它的特性集较ArrayList更大
		Set
			HashSet、TreeSet和LinkedHashSet，每个相同的项只保存一次
			HashSet使用复杂的方式来存储，是最快的获取元素的方式，存储的顺序在此无意义
			如果存储顺序很重要那可以使用TreeSet。它按照比较结果的升序保存对象，或者使
			用LinkedHashSet，它按照被添加的顺序保存对象
		Map
			HashMap、TreeMap、LinkedHashMap，HashMap提供了很快的查找技术，也没有按照明显顺序
			进行排序
			TreeMap按照比较结果的升序保存键
			LinkedHashMap则按照插入顺序保存键且保留了HashMap的查询速度
# 总结：
		数组将数字与对象练习起来。它保存类型明确的对象，查询对象的时候不用对结果做转换，可以多维，
	也可以直接保存基本数据类型，但一旦生成，容量不能改变。而List能自动扩容
		Collection保存单一的元素，Map保存键值对，它们会自动调整其尺寸，容器不能持有基本类型，但是
	它们会帮你执行装箱和拆箱的操作
		如果有大量的随机访问，就使用ArrayList；
		如果需要频繁从表中间插入或删除元素，使用LinkedList
		Queue和栈都是由LinkedList提供支持
		Map是一种对象和对象关联的设计，HashMap用来快速访问；TreeMap保持键始终处于排序状态，
	所以访问没HashMap快，LinkedHashMap集二者的优点
		Set不接受重复元素，HashSet提供最快的查询速度，TreeSet保持元素处于排序状态
	而LinkedHashSet集二者的优点
		从前的Vector、Hashtable和Stack已经过时，不再使用
	
