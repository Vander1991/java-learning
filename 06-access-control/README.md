# Java解释器解析包名的运行过程
	1、首先，找出环境变量CLASSPATH，CLASSPATH包括一个或多个目录，用作查找.class文件的根目录。
	2、从根目录开始，解释器获取包的名称并将每个句点替换成反斜杠，以从CLASSPATH根中产生一个路径名称（于是，package foo.bar.baz
		就变成了foo/bar/baz取决操作系统）。
	3、得到的路径会与CLASSPATH中的各个不同的项相连接，解释器就在这些目录中查找与你所要创建的类名称相关的.class文件。（解释器
		还会去查找某些涉及Java解释器所在位置的标准目录）
		
# 类的访问权限只有public和包访问权限

# 内部类可以是private或者protected，是个特例



