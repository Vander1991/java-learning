package szu.vander.exception.discussion.practice.practice30;

/**
 * 
 * @author : Vander
 * @date : 2018-11-23
 * @description :
 */
class WrapCheckedException {

	void throwRuntimeException(int type) {
		try {
			switch (type) {
			case 0:
				throw new Annoyance();
			case 1:
				throw new Sneeze();
			case 2:
				throw new RuntimeException("Where am I?");
			default:
				return;
			}
		} catch (Exception e) { // Adapt to unchecked:
			throw new RuntimeException(e);
		}
	}
}

class Annoyance extends RuntimeException {
	private static final long serialVersionUID = 1L;
}

class Sneeze extends Annoyance {
	private static final long serialVersionUID = 1L;
}

public class Human {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			try {
				WrapCheckedException wrapCheckedException = new WrapCheckedException();
				wrapCheckedException.throwRuntimeException(i);
			} catch (RuntimeException e) {
				try {
					throw e.getCause();
				} catch (Sneeze e1) {
					e1.printStackTrace();
				} catch (Annoyance e1) {
					e1.printStackTrace();
				} catch (RuntimeException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
