package szu.vander.typeinfo.nullobject.exercise24;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import szu.vander.util.Null;

/**
 * 
 * @author : Vander
 * @date : 2018-12-09
 * @description :
 */
interface IPart {
}

class NullPartProxyHandler implements InvocationHandler {
	private String nullName;
	private IPart proxied = new NIPart();

	NullPartProxyHandler(Class<? extends IPart> type) {
		nullName = type.getSimpleName() + ": [Null IPart]";
	}

	private class NIPart implements Null, IPart {
		public String toString() {
			return nullName;
		}
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(proxied, args);
	}
}

class Part implements IPart {
	public String toString() {
		return getClass().getSimpleName();
	}

	public static IPart newNull(Class<? extends IPart> type) {
		return (IPart) Proxy.newProxyInstance(
				IPart.class.getClassLoader(), 
				new Class<?>[] { Null.class, IPart.class },
				new NullPartProxyHandler(type));
	}

	static List<Factory<IPart>> partFactories = new ArrayList<Factory<IPart>>();
	static {
		partFactories.add(new FuelFilter.FactoryImpl());
		partFactories.add(new AirFilter.FactoryImpl());
		partFactories.add(new CabinAirFilter.FactoryImpl());
		partFactories.add(new OilFilter.FactoryImpl());
		partFactories.add(new FanBelt.FactoryImpl());
		partFactories.add(new PowerSteeringBelt.FactoryImpl());
		partFactories.add(new GeneratorBelt.FactoryImpl());
	}
	private static Random rand = new Random(47);

	public static IPart createRandom() {
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}

class Filter extends Part {
}

class FuelFilter extends Filter {
	// Create a Class Factory for each specific type:
	public static class FactoryImpl implements Factory<IPart> {
		public IPart create() {
			return new FuelFilter();
		}
	}
}

class AirFilter extends Filter {
	public static class FactoryImpl implements Factory<IPart> {
		public IPart create() {
			return new AirFilter();
		}
	}
}

class CabinAirFilter extends Filter {
	public static class FactoryImpl implements Factory<IPart> {
		public IPart create() {
			return new CabinAirFilter();
		}
	}
}

class OilFilter extends Filter {
	public static class FactoryImpl implements Factory<IPart> {
		public IPart create() {
			return new OilFilter();
		}
	}
}

class Belt extends Part {
}

class FanBelt extends Belt {
	public static class FactoryImpl implements Factory<IPart> {
		public IPart create() {
			return new FanBelt();
		}
	}
}

class GeneratorBelt extends Belt {
	public static class FactoryImpl implements Factory<IPart> {
		public IPart create() {
			return new GeneratorBelt();
		}
	}
}

class PowerSteeringBelt extends Belt {
	public static class FactoryImpl implements Factory<IPart> {
		public IPart create() {
			return new PowerSteeringBelt();
		}
	}
}

public class RegisteredFactories {

} /*
	 * Output: GeneratorBelt CabinAirFilter GeneratorBelt AirFilter
	 * PowerSteeringBelt CabinAirFilter FuelFilter PowerSteeringBelt
	 * PowerSteeringBelt FuelFilter
	 */// :~
