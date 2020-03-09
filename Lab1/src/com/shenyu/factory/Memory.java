package com.shenyu.factory;

public abstract class Memory extends ComputerItem {
	
	protected int volume;
	
	public Memory(String name, int price, int volume) {
		super(name, price, "Memory");
		this.volume = volume;
	}
}
