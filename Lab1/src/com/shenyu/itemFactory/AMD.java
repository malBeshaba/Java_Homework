package com.shenyu.itemFactory;

import com.shenyu.factory.CPU;

public class AMD extends CPU {
	public AMD(String name, int coreNum, int price) {
		super(name, price, coreNum);
	}
}
