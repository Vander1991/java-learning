//: innerclasses/controller/Controller.java
// The reusable framework for control systems.
package szu.vander.innerclass.controlframework;

import java.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-15
* @description : 就目前的设计中并不知道Event会做什么，这就是此设计的关键所在，“使变化的事物与不变的事物相互分离”
* 				变化的是各种Event的子类，不变的是框架的处理逻辑
 */
public class Controller {
	// A class from java.util to hold Event objects:
	private List<Event> eventList = new ArrayList<Event>();

	public void addEvent(Event c) {
		eventList.add(c);
	}

	public void run() {
		while (eventList.size() > 0)
			// Make a copy so you're not modifying the list
			// while you're selecting the elements in it:
			for (Event e : new ArrayList<Event>(eventList))
				if (e.ready()) {
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
	}
}
