package szu.vander.resourceshare.error;

//: concurrency/IntGenerator.java

public abstract class IntGenerator {
	// 因为canceled标志是boolean类型的，所以它是原子性的，即诸如赋值和返回值这样的简单操作在发生时
	// 没有中断的可能，不会在这个field处于在执行这些简单操作过程的中间状态
	// 再者它是volatile保证了可视性。
	private volatile boolean canceled = false;

	public abstract int next();

	// Allow this to be canceled:
	public void cancel() {
		canceled = true;
	}

	public boolean isCanceled() {
		return canceled;
	}
} /// :~
