package com.shenyu.itemFactory;

import com.shenyu.factory.*;

public class ComputerFactory extends Factory {

	@Override
	public CPU creatCPU(String name, int price, int coreNum, String brand) {
		if(brand.equals("Intel")) {
			return new Intel(name, price, coreNum);
		}else if(brand == "AMD") {
			return new AMD(name, price, coreNum);
		}
		return null;
	}

	@Override
	public HD creatHD(String name, int price, int volume, String brand) {
		if(brand.equals("Seagate")) {
			return new Seagate(name, price, volume);
		}else if(brand == "WestDigitals") {
			return new WestDigitals(name, price, volume);
		}
		return null;
	}

	@Override
	public Mainboard creatMainboard(String name, int price, int speed, String brand) {
		if(brand.equals("Asus")) {
			return new Asus(name, price, speed);
		}else if(brand == "Gigabyte") {
			return new Gigabyte(name, price, speed);
		}
		return null;
	}

	@Override
	public Memory creatMemory(String name, int price, int volume, String brand) {
		if(brand.equals("Samsung")) {
			return new Samsung(name, price, volume);
		}else if(brand == "Kingston") {
			return new Kingston(name, price, volume);
		}
		return null;
	}

	@Override
	public Computer creatComputer(String name) {
		return new TrueComputer(name);
	}

}
