package com.shenyu.factory;

import com.shenyu.itemFactory.AMD;

public abstract class ComputerItem {
	
	protected String name; 	// 每个零件都要有的 name
	protected int price;	// 每个零件都要有的 price
	protected String type;	// 每个零件都要有一个 类型
	
	public ComputerItem(String name, int price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}
	// 每个零件都要工作
	public void work() {
		System.out.println(type + " work");
	}
}
