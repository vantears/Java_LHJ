package day15.practice.shop.product;

import lombok.Data;

@Data
public class customer {
	String name;
	
	public customer(String name) {
		this.name = name;
	}
}
