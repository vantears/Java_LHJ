package day17.practice.vo;

import lombok.Data;

@Data
public class salesHistory {
	private customer customer;
	private product product;
	private int amount;
	private int price;
	
	public salesHistory(customer customer, product product, int amount) {
		this.customer = customer;
		this.product = product;
		this.amount = amount;
		this.price = product.getPrice() * amount;

	}
	
	public salesHistory(customer customer, product product) {
		this.customer = customer;
		this.product = product;
		amount = product.getAmount();
		price = product.getPrice() * amount;
	}

	public void printHistory() {
		System.out.println("Customer : " + customer.getName() + "(" + customer.getPhoneNumber() + ")");
		System.out.println("Product : " + product.getProductName());
		System.out.println("Quantity : " + amount);
		System.out.println("Total purchase : $" + price);
	}

}
