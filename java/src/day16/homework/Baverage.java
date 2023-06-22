package day16.homework;

import lombok.Data;

@Data
public class Baverage {

	String name;
	int price;
	int amount;
	
	public Baverage(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
		
	public void store(int amount) {
		this.amount += amount;
	}
	
	public void sellOut() {
		this.amount--;
	}
}
