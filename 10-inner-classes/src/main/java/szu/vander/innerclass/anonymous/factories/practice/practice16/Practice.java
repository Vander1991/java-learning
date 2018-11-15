package szu.vander.innerclass.anonymous.factories.practice.practice16;
/**
* @author      : Vander
* @date        : 2018-11-15
* @description ： 
*/
interface Cycle {
	void ride();
}

interface CycleFactory {
	Cycle makeCycle();
}

class Unicycle implements Cycle {

	public void ride() {
		System.out.println("Ride Unicycle");
	}
	
	public static CycleFactory cycleFactory = new CycleFactory() {
		public Cycle makeCycle() {
			return new Unicycle();
		}
	};

}

class Bicycle implements Cycle {

	public void ride() {
		System.out.println("Ride Bicycle");
	}
	
	public static CycleFactory cycleFactory = new CycleFactory() {
		public Cycle makeCycle() {
			return new Bicycle();
		}
	};

}

class Tricycle implements Cycle {

	public void ride() {
		System.out.println("Ride Trcycle");
	}
	
	public static CycleFactory cycleFactory = new CycleFactory() {
		public Cycle makeCycle() {
			return new Tricycle();
		}
	};

}

public class Practice {
	
	public static void ride(CycleFactory cycleFactory) {
		cycleFactory.makeCycle().ride();
	}
	
	public static void main(String args[]) {
		ride(Unicycle.cycleFactory);
		ride(Bicycle.cycleFactory);
		ride(Tricycle.cycleFactory);
	}
}
