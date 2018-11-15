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

interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

public class HorrorShow {
	
	public DangerousMonster getMonster() {
		return new DangerousMonster() {
			public void menace() {
				System.out.println("DangerousMonster menace");
			}

			public void destroy() {
				System.out.println("DangerousMonster destroy");
			}
			
		};
	}
	
	public Vampire getVampire() {
		return new Vampire() {
			public void destroy() {
				System.out.println("Vampire destroy");
			}

			public void menace() {
				System.out.println("Vampire menace");
			}

			public void kill() {
				System.out.println("Vampire kill");
			}

			public void drinkBlood() {
				System.out.println("Vampire drinkBlood");
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
		HorrorShow horrorShow = new HorrorShow();
		DangerousMonster barney = horrorShow.getMonster();
		menace(barney);
		menaceAndDestroy(barney);
		Vampire vlad = horrorShow.getVampire();
		menace(vlad);
		menaceAndDestroy(vlad);
		kill(vlad);
	}
} /// :~
