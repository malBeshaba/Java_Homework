package com.shenyu.factory;

import java.util.ArrayList;

public abstract class Computer {
	
	protected String name;
	protected String describe = "";
	protected int price = 0;
	
	protected ArrayList<ComputerItem> items = new ArrayList<>();
	
	public Computer(String name) {
		this.name = name;
	}
	
	public void add(ComputerItem item) {
		items.add(item);
		this.price += item.price;
		this.describe += item.type + ": " + item.getClass().getSimpleName() + " " + item.name + "\r\n";
	}
	
	public abstract void work();

	
	public String getName() {
		return this.name;
	}
	
	public String getDescribe() {
		return describe;
	}
	
	public int getPrice() {
		return price;
	}

}
