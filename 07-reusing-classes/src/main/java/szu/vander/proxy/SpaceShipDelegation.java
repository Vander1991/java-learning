package szu.vander.proxy;
/**
* @author      : Vander
* @date        : 2018-11-09
* @description ： 使用代理可以让SpaceShipControls的方法不被暴露,相当于这里能控制哪些SpaceShipControls的
* 				 方法能够被调用，哪些不能。
*/
public class SpaceShipDelegation {

	private String name;

	private SpaceShipControls controls = new SpaceShipControls();
	
	public SpaceShipDelegation(String name) {
		super();
		this.name = name;
	}

	//Delegated methods
	public void back(int velocity) {
		controls.back(velocity);
	}
	
	public void forward(int velocity) {
		controls.forward(velocity);
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String args[]) {
		SpaceShipDelegation spaceShip = new SpaceShipDelegation("Nasa");
		spaceShip.forward(100);
	}
	
}
