package com.shenyu.itemFactory;

import java.util.Iterator;

import com.shenyu.factory.*;

public class TrueComputer extends Computer{

	public TrueComputer(String name) {
		super(name);
	}

	@Override
	public void work() {
		System.out.println("计算机开始工作：");
		Iterator<ComputerItem> it = items.iterator();
		while(it.hasNext()) {
			ComputerItem item = (ComputerItem)it.next();
			item.work();
		}
	}
	
}
