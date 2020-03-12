package com.shenyu.store;

import com.shenyu.factory.*;
import com.shenyu.factory.Computer;
import com.shenyu.factory.HD;
import com.shenyu.factory.Memory;
import com.shenyu.itemFactory.Intel;
import com.shenyu.itemFactory.Samsung;
import com.shenyu.itemFactory.Seagate;

public class ComputerStore {
	
	private Computer computer1;
	private Computer computer2;
	private Computer computer3;
	
	public ComputerStore(Computer computer1, Computer computer2, Computer computer3) {
		this.computer1 = computer1;
		this.computer2 = computer2;
		this.computer3 = computer3;
	}
	
	public void printGoods() {
		System.out.println("本店包含商品为：");
		System.out.println(computer1.getName());
		System.out.println(computer2.getName());
		System.out.println(computer3.getName());
	}
	
	public void printPrice() {
		System.out.println("本店商品价格为: ");
		System.out.println("" + computer1.getName() + "的价格: " + computer1.getPrice());
		System.out.println("" + computer2.getName() + "的价格: " + computer2.getPrice());
		System.out.println("" + computer3.getName() + "的价格: " + computer3.getPrice());
	}
	
	public void printDescribe() {
		System.out.println("商品描述为: ");
		System.out.println("" + computer1.getName() + "的描述:");
		System.out.println(computer1.getDescribe());
		System.out.println("" + computer2.getName() + "的描述:");
		System.out.println(computer2.getDescribe());
		System.out.println("" + computer3.getName() + "的描述:");
		System.out.println(computer3.getDescribe());
	}
	
	public void work() {
		System.out.println("" + computer1.getName() + "开始工作:");
		computer1.work();
		
		System.out.println("" + computer2.getName() + "开始工作:");
		computer2.work();
		
		System.out.println("" + computer3.getName() + "开始工作:");
		computer3.work();
	}
	
	public static void main(String[] args) {
		Factory factory = Factory.getFactory("ComputerFactory");
		
		CPU cpu1 = factory.creatCPU("cpu_name1", 4, 2999, "Intel");
		Memory memory1 = factory.creatMemory("memory_name1", 123, 2000, "Samsung");
		HD hd1 = factory.creatHD("hd_name1", 300, 16, "Seagate");
		Mainboard mainboard1 = factory.creatMainboard("mainboard_name1", 123, 333, "Asus");
		
		Computer computer1 = factory.creatComputer("暗影精灵");
		computer1.add(cpu1);
		computer1.add(memory1);
		computer1.add(hd1);
		computer1.add(mainboard1);
		
		CPU cpu2 = factory.creatCPU("cpu_name2", 1000, 4000, "AMD");
		Memory memory2 = factory.creatMemory("memory_name2", 400, 2000, "Kingston");
		HD hd2 = factory.creatHD("hd_name2", 300, 16, "Seagate");
		Mainboard mainboard2 = factory.creatMainboard("mainboard_name2", 129, 633, "Asus");
		
		Computer computer2 = factory.creatComputer("神州");
		computer2.add(cpu2);
		computer2.add(memory2);
		computer2.add(hd2);
		computer2.add(mainboard2);
		
		CPU cpu3 = factory.creatCPU("cpu_name3", 3000, 4000, "AMD");
		Memory memory3 = factory.creatMemory("memory_name3", 1000, 2000, "Kingston");
		HD hd3 = factory.creatHD("hd_name3", 1000, 16, "WestDigitals");
		Mainboard mainboard3 = factory.creatMainboard("mainboard_name3", 1000, 2000, "Gigabyte");
		
		Computer computer3 = factory.creatComputer("Mac");
		computer3.add(cpu3);
		computer3.add(memory3);
		computer3.add(hd3);
		computer3.add(mainboard3);
		
		ComputerStore store = new ComputerStore(computer1, computer2, computer3);
		
		store.printGoods();
		System.out.println("--------------");
		store.work();
		System.out.println("--------------");
		store.printPrice();
		System.out.println("--------------");
		store.printDescribe();
	}

}
