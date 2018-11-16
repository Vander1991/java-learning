package szu.vander.innerclass.controlframework.practice.practice25;

import szu.vander.innerclass.controlframework.Controller;
import szu.vander.innerclass.controlframework.Event;

//: innerclasses/GreenhouseControls.java
// This produces a specific application of the
// control system, all in a single class. Inner
// classes allow you to encapsulate different
// functionality for each type of event.

public class GreenhouseControls extends Controller {

	private boolean waterDistributor;
	
	public class WaterDistributorOpen extends Event {

		public WaterDistributorOpen(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			waterDistributor = true;
			setDelayTime((long)Math.pow(10, 9)*2);
			addEvent(this);
			start();
		}
		
		public String toString() {
			return "Open Water Distributor";
		}
		
		public boolean getWaterDistributorState() {
			return waterDistributor;
		}
		
	}

	public class WaterDistributorClose extends Event {

		public WaterDistributorClose(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			waterDistributor = false;
			setDelayTime((long)Math.pow(10, 9)*2);
			addEvent(this);
			start();
		}
		
		public String toString() {
			return "Close Water Distributor";
		}
		
		public boolean getWaterDistributorState() {
			return waterDistributor;
		}
		
	}
	
	public static class Terminate extends Event {
		public Terminate(long delayTime) {
			super(delayTime);
		}

		public void action() {
			System.exit(0);
		}

		public String toString() {
			return "Terminating";
		}
	}
	
	public static void main(String args[]) {
		GreenhouseControls gc = new GreenhouseControls();
		// 启动程序开启喷水机
		Event e1 = gc.new WaterDistributorOpen(0);
		// 再过了1秒后关闭喷水机
		Event e2 = gc.new WaterDistributorClose((long)Math.pow(10, 9));
		// 10秒后结束进程
		Event e3 = new GreenhouseControls.Terminate((long)Math.pow(10, 10));
		gc.addEvent(e1);
		gc.addEvent(e2);
		gc.addEvent(e3);
		gc.run();
	}
	
}
