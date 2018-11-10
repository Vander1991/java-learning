package szu.vander.proxy;
/**
* @author      : Vander
* @date        : 2018-11-09
* @description ： 不使用代理的话，SpaceShipControls的所有方法都在SpaceShip中暴露出来
*/
public class SpaceShip extends SpaceShipControls {

	private String name;
	
	public SpaceShip(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public static void main(String args[]) {
		SpaceShip spaceShip = new SpaceShip("NSEA Protector");
		spaceShip.forward(100);
	}
	
}
