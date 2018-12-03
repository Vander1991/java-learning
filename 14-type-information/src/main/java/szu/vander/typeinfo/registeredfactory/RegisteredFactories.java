package szu.vander.typeinfo.registeredfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
* @author      : Vander
* @date        : 2018-12-02
* @description : 为了解决LiteralPetCreator中所说的问题（这里没明白），将列表至于一个位于中心的位置明显的地方
* 				也就是继承结构中的基类，将列表维护在基类中。
* 				 下面用了工厂方法模式，将对象的创建工作交给类自己去做。
 */
class Part {
	public String toString() {
		return getClass().getSimpleName();
	}

	static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
	
	static {
		// Collections.addAll() gives an "unchecked generic
		// array creation ... for varargs parameter" warning.
//		Collections.addAll(partFactories, new FuelFilter.Factory(),
//				new AirFilter.Factory(), new CabinAirFilter.Factory(),
//				new OilFilter.Factory(), new FanBelt.Factory(),
//				new PowerSteeringBelt.Factory(), new GeneratorBelt.Factory());
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFilter.Factory());
		partFactories.add(new CabinAirFilter.Factory());
		partFactories.add(new OilFilter.Factory());
		partFactories.add(new FanBelt.Factory());
		partFactories.add(new PowerSteeringBelt.Factory());
		partFactories.add(new GeneratorBelt.Factory());
	}
	
	private static Random rand = new Random(47);

	public static Part createRandom() {
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}

class Filter extends Part {
}

class FuelFilter extends Filter {
	// Create a Class Factory for each specific type:
	public static class Factory implements szu.vander.typeinfo.registeredfactory.Factory<FuelFilter> {
		public FuelFilter create() {
			return new FuelFilter();
		}
	}
}

class AirFilter extends Filter {
	public static class Factory implements szu.vander.typeinfo.registeredfactory.Factory<AirFilter> {
		public AirFilter create() {
			return new AirFilter();
		}
	}
}

class CabinAirFilter extends Filter {
	public static class Factory implements szu.vander.typeinfo.registeredfactory.Factory<CabinAirFilter> {
		public CabinAirFilter create() {
			return new CabinAirFilter();
		}
	}
}

class OilFilter extends Filter {
	public static class Factory implements szu.vander.typeinfo.registeredfactory.Factory<OilFilter> {
		public OilFilter create() {
			return new OilFilter();
		}
	}
}

class Belt extends Part {
}

class FanBelt extends Belt {
	public static class Factory implements szu.vander.typeinfo.registeredfactory.Factory<FanBelt> {
		public FanBelt create() {
			return new FanBelt();
		}
	}
}

class GeneratorBelt extends Belt {
	public static class Factory implements szu.vander.typeinfo.registeredfactory.Factory<GeneratorBelt> {
		public GeneratorBelt create() {
			return new GeneratorBelt();
		}
	}
}

class PowerSteeringBelt extends Belt {
	public static class Factory implements szu.vander.typeinfo.registeredfactory.Factory<PowerSteeringBelt> {
		public PowerSteeringBelt create() {
			return new PowerSteeringBelt();
		}
	}
}

public class RegisteredFactories {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Part.createRandom());
		}
	}
} /*
	 * Output: GeneratorBelt CabinAirFilter GeneratorBelt AirFilter
	 * PowerSteeringBelt CabinAirFilter FuelFilter PowerSteeringBelt
	 * PowerSteeringBelt FuelFilter
	 */// :~
