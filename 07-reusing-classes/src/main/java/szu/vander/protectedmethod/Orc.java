package szu.vander.protectedmethod;

import static szu.vander.util.Print.*;
/**
* @author      : Vander
* @date        : 2018-11-09
* @description ： charge()可以访问set()，因为它是Protected
*/
public class Orc extends Villain {
	// Villain-坏人, Orc妖魔
	private int orcNumber;
	
	public Orc(String name, int orcNumber) {
		super(name);
		this.orcNumber = orcNumber;
	}
	
	public void charge(String name, int orcNumber) {
		// 由于是Protected的所以能这么写
		set(name);
		this.orcNumber = orcNumber;
	}
	
	public String toString() {
		return "Orc" + orcNumber + ": " + super.toString();
	}
	
	public static void main(String args[]) {
		// Limburger-比利时原产干酪之一种
		Orc orc = new Orc("Limburger", 12);
		print(orc);
		orc.charge("Vander", 18);
		print(orc);
	}
	
}

class Villain {
	
	private String name;
	
	protected void set(String name) {
		this.name = name;
	}
	
	public Villain(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "I'm a Villain and my name is " + name;
	}
	
}
