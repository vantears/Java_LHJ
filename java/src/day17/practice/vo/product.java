package day17.practice.vo;

import lombok.Data;

@Data
public class product {
	private String productName;
	private String modelName;
	private int price;
	private int amount;
	private String category;
	
	//생성자
	public product(String productName, String modelName, int price, int amount, String category) {
		this.productName = productName;
		this.modelName = modelName;
		this.price = price;
		this.amount = amount;
		this.category = category;
	}
	public product(String productName, int amount) {
		this.productName = productName;
		this.amount = amount;
	}
	
	public product(product product) {
		this.productName = product.getProductName();
		this.modelName = product.getModelName();
		this.price = product.getPrice();
		this.amount = product.getAmount();
		this.category = product.getCategory();
	}

	public product(String search) {
		this.productName = search;
	}
	//메서드
	public void store(int amount) {
		if(amount < 0) {
			return;
		}
		accumulate(amount);
	}
	
	public void sellOut(int amount) {
		if(amount < 0) {
			return;
		}
		accumulate(-amount);
	}
	
	private void accumulate(int amount) {
		this.amount += amount;
	}
	
	public void printProduct() {
		System.out.println("---------------");
		System.out.println("Name : " + this.productName);
		System.out.println("Model : " + this.modelName);
		System.out.println("Price : $" + this.price);
		System.out.println("Stored amount : " + this.amount);
		System.out.println("Category : " + this.category);
	}
}
	
	