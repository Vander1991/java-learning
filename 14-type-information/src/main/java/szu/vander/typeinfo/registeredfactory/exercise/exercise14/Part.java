package szu.vander.typeinfo.registeredfactory.exercise.exercise14;

import java.util.Arrays;
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
public class Part {
	public String toString() {
		return getClass().getSimpleName();
	}

	static List<Class<? extends Part>> partFactories = Arrays.asList(
			Filter.class, FuelFilter.class, AirFilter.class, CabinAirFilter.class,
			OilFilter.class, Belt.class
			);

	private static Random rand = new Random(47);

	public static Part createRandom() {
		Part part = null;
		int n = rand.nextInt(partFactories.size());
		try {
			part = partFactories.get(n).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return part;
	}
}

class Filter extends Part {
}

class FuelFilter extends Filter {
}

class AirFilter extends Filter {
}

class CabinAirFilter extends Filter {
}

class OilFilter extends Filter {
}

class Belt extends Part {
}

class FanBelt extends Belt {
}

class GeneratorBelt extends Belt {
}

class PowerSteeringBelt extends Belt {
}
