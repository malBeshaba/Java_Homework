package com.shenyu.factory;
// 抽象表示 CPU 的类
public abstract class CPU extends ComputerItem {

	protected int coreNum;

	public CPU(String name, int price, int coreNum) {
		super(name, price, "CPU");
		this.coreNum = coreNum;
	}
}