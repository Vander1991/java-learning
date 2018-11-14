package szu.vander.innerclass.methodandfield;

//: innerclasses/Parcel6.java
// Nesting a class within a scope.

/**
 * 
* @author      : Vander
* @date        : 2018-11-14
* @description ：  在任何作用域内都能使用内部类，一旦出了该作用域就不可访问该内部类了
 */
public class Parcel6 {
	private void internalTracking(boolean b) {
		if (b) {
			class TrackingSlip {
				private String id;

				TrackingSlip(String s) {
					id = s;
				}

				String getSlip() {
					return id;
				}
			}
			TrackingSlip ts = new TrackingSlip("slip");
			String s = ts.getSlip();
			System.out.println(s);
		}
		// Can't use it here! Out of scope:
		// ! TrackingSlip ts = new TrackingSlip("x");
	}

	public void track() {
		internalTracking(true);
	}

	public static void main(String[] args) {
		Parcel6 p = new Parcel6();
		p.track();
	}
} /// :~
