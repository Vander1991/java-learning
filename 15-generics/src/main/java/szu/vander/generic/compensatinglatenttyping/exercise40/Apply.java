package szu.vander.generic.compensatinglatenttyping.exercise40;

//: generics/Apply.java
// {main: ApplyTest}
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 
 * @author     : Vander
 * @date       : 2019-01-01
 * @description: 
 */
public class Apply {
	public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
		try {
			for (T t : seq)
				f.invoke(t, args);
		} catch (Exception e) {
			// Failures are programmer errors
			throw new RuntimeException(e);
		}
	}
}

class FilledList<T> extends ArrayList<T> {
	public FilledList(Class<? extends T> type, int size) {
		try {
			for (int i = 0; i < size; i++)
				// Assumes default constructor:
				add(type.newInstance());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}