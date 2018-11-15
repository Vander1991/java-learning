package szu.vander.innerclass.multiinherit.practice.practice23;
/**
* @author      : Vander
* @date        : 2018-11-15
* @description ： 
*/
interface U {
	void a();
	void b();
	void c();
}

class A {

	private String name;
	
	public A(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public U getU() {
		return new U() {
			public void a() {
				System.out.println(A.this.name + "： a()");
			}
			public void b() {
				System.out.println(A.this.name + "： b()");
			}
			public void c() {
				System.out.println(A.this.name + "： c()");
			}
		};
	}
}

class B {
	
	private int position;
	
	private static final int LENGTH = 10; 
	
	private U[] arrU;
	
	public B() {
		position = 0;
		arrU = new U[LENGTH];
	}
	
	public void add(U u) {
		arrU[position++] = u;
	}
	
	public void remove(int position) {
		arrU[position] = null;
	}
	
	public void traverse() {
		for(U u : arrU) {
			if(u == null) {
				return;
			}
			u.a();
			u.b();
			u.c();
		}
	}
	
}

public class Practice {
	public static void main(String args[]) {
		A[] arrA = {new A("A1"), new A("B1"), new A("C1")};
		B b = new B();
		for(A a : arrA) {
			b.add(a.getU());
		}
		b.traverse();
		
		b.remove(0);
		b.remove(1);
		b.remove(2);
		
		System.out.println("end!");
	}
}
