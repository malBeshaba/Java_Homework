package com.shenyu.factory;

public abstract class HD extends ComputerItem {
	
	protected int volume;
	
	public HD(String name, int price, int volume) {
		super(name, price, "HD");
		this.volume = volume;
	}
}
