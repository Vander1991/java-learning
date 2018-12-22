package szu.vander.generic.question;

//: generics/RestrictedComparablePets.java

/**
 * 
 * @author     : Vander
 * @date       : 2018-12-20
 * @description: Hamster说明再次实现ComparablePet中的相同接口是可能得，只要包括参数类型在内的都相同
 */
class Hamster extends ComparablePet implements Comparable<ComparablePet> {
	public int compareTo(ComparablePet arg) {
		return 0;
	}
}

// Or just:

class Gecko extends ComparablePet {
	public int compareTo(ComparablePet arg) {
		return 0;
	}
} /// :~
