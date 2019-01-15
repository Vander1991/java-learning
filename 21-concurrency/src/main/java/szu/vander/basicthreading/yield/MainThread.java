package szu.vander.basicthreading.yield;

//: concurrency/MainThread.java

/**
 * 
* @author      : Vander
* @date        : 2019-01-15
* @description ： LiftOff中的yield方法仅仅是暗示调度器，你的工作已经做得差不多了，可以让别的线程使用CPU了。（这只是暗示，没有
* 				任何机制保证它将会被采纳）。当调用yield()时，只是建议具有相同优先级的其他线程可以运行。
 */
public class MainThread {
	public static void main(String[] args) {
		LiftOff launch = new LiftOff();
		launch.run();
	}
} /*
	 * Output: #0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1),
	 * #0(Liftoff!),
	 */// :~
