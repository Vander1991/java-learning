package szu.vander.array.firstclassobject.exercise1;

/**
 * @author : Vander
 * @date : 2019-01-05
 * @description: 创建一个手BerylliumSphere数组作为参数的方法，并动态地创建参数去调用这个方法。
 *               证明在本例中普通的聚集数组初始化不能奏效，去发现总结在哪些情况下，普通聚集初始化可以
 *               起作用，而又在哪些情况下，动态聚集初始化显得多余
 */

class BerylliumSphere {
	
}

public class Exercise1 {
	static void hide(BerylliumSphere[] s) {
		System.out.println("Hiding " + s.length + " sphere(s)");
	}

	public static void main(String[] args) {
		// Dynamic aggregate initialization:
		hide(new BerylliumSphere[] { new BerylliumSphere(), new BerylliumSphere() });
		// The following line produces a compilation error.
		// ! hide({ new BerylliumSphere() });
		// Aggregate initialization:
		BerylliumSphere[] d = { new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere() };
		hide(d);
		// Dynamic aggregate initialization is redundant(多余)
		// in the next case:
		BerylliumSphere[] a = new BerylliumSphere[] { new BerylliumSphere(), new BerylliumSphere() };
		hide(a);
	}
}
