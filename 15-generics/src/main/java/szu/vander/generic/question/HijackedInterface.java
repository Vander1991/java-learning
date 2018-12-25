package szu.vander.generic.question;

//: generics/HijackedInterface.java
// {CompileTimeError} (Won't compile)
// 一旦为Comparable确定了ComparablePet参数，那么其他任何实现类都不能与ComparablePet之外的任何对象比较
//class Cat extends ComparablePet implements Comparable<Cat> {
//	// Error: Comparable cannot be inherited with
//	// different arguments: <Cat> and <Pet>
//	public int compareTo(Cat arg) {
//		return 0;
//	}
//}
