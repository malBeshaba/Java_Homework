package com.shenyu.factory;

import com.shenyu.itemFactory.ComputerFactory;

public abstract class Factory {
	public static Factory getFactory(String factoryClassName) {
		Factory factory = new ComputerFactory();
		return factory;
	}
	
	public abstract CPU creatCPU(String name, int price, int coreNum, String brand);
	public abstract HD creatHD(String name, int price, int volume, String brand);
	public abstract Mainboard creatMainboard(String name, int price, int speed, String brand);
	public abstract Memory creatMemory(String name, int price, int volume, String brand);
	public abstract Computer creatComputer(String name);
}
