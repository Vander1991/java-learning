package szu.vander.innerclass.anonymous.practice.practice14;

//: interfaces/HorrorShow.java
// Extending an interface with inheritance.

interface Monster {
	// menace-威胁
	void menace();
}

interface DangerousMonster extends Monster {
	void destroy();
}

interface Lethal {
	// lethal-致死的
	void kill();
}

class DragonZilla implements DangerousMonster {
	public void menace() {
	}

	public void destroy() {
	}
}

interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

class VeryBadVampire implements Vampire {
	public void menace() {
	}

	public void destroy() {
	}

	public void kill() {
	}

	public void drinkBlood() {
	}
}

public class HorrorShow {
	
	public DangerousMonster getDangerousMonster() {
		return new DangerousMonster() {
			public void menace() {
				System.out.println("DangerousMonster menace");
			}

			public void destroy() {
				System.out.println("DangerousMonster destroy");
			}
			
		};
	}
	
	static void menace(Monster b) {
		b.menace();
	}

	static void menaceAndDestroy(DangerousMonster d) {
		d.menace();
		d.destroy();
	}

	static void kill(Lethal l) {
		l.kill();
	}

	public static void main(String[] args) {
		DangerousMonster barney = new DragonZilla();
		menace(barney);
		menaceAndDestroy(barney);
		Vampire vlad = new VeryBadVampire();
		menace(vlad);
		menaceAndDestroy(vlad);
		kill(vlad);
	}
} /// :~
