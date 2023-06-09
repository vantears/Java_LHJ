package day15.practice.shop.product;

import lombok.Data;

@Data
public class customer {
	private String customerId;
	private String name;
	private String phoneNumber;
	
	private static int count;
	
	private final static String CID = "CID";
	private final static int MAX_SIZE = 5;
	
	public customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		generateCustomerId();
	}

	private void generateCustomerId() {
		String num = "" + ++count;
		int length = num.length();
		for(int i = 0; i < MAX_SIZE - length; i++) {
			num = "0" + num;
		}
		
		customerId = CID + num;
		
	}
	
	public void print() {
		System.out.println("-------------------");
		System.out.println("Customer ID : " + customerId);
		System.out.println("Name : " + name);
		System.out.println("Phone number : " + phoneNumber);
	}
}
