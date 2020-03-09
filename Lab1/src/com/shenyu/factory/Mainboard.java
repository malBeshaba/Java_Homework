package com.shenyu.factory;

public abstract class Mainboard extends ComputerItem {

	protected int speed;
	
	public Mainboard(String name, int price, int speed) {
		super(name, price, "Mainboard");
		this.speed = speed;
	}
}
