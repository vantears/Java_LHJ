package day17.practice.service;

import day17.practice.vo.customer;
import day17.practice.vo.product;
import day17.practice.vo.salesHistory;

public class ShopServiceImp implements ShopService {

	@Override
	public int store(product[] productList, int count, product product) {
		//if no such product exists in the list. not store and just return the current count
		if(product == null) {
			return count;
		}
		if(productList == null || count < 0) {
			return 0;
		}
		
		if(productList.length < count) {
			return productList.length;
		}

		int index = indexOf(productList, count, product);
		if(index != -1) {
			productList[index].store(product.getAmount());
			return count;
		}
		if(count == productList.length) {
			return count;
		}
		productList[count] = new product(product);
		return count + 1;
	}

	private int indexOf(product[] productList, int count, product product) {
		if(product == null || product.getProductName() == null) {
			return -1;
		}
		if(productList == null) {
			return -1;
		}
		if(count > productList.length || count < 0) {
			count = productList.length;
		}
		for(int i = 0; i < count; i++) {
			product tmp = productList[i];
			if(tmp == null || 
					tmp.getProductName() == null || 
					product.getProductName() == null) {
				return -1;
			}
			if(tmp.getProductName().equals(product.getProductName())) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void printProduct(product[] productList, int count, String search) {
		if(productList == null || search == null) {
			System.out.println("No such product is found!");
			return;
		}
		int index = indexOf(productList, count, new product(search));
		if(index == -1) {
			System.out.println("No such product is found!");
			return;
		}
		productList[index].printProduct();
	}

	@Override
	public int registerCustomer(customer[] customerList, int countC, customer customer) {
		if(customerList == null 
			|| countC < 0 
			|| customer == null 
			|| customer.getPhoneNumber() == null
			|| customerList.length <= countC) {
			return -1;
		}
		for(int i =0; i < countC; i++) {
			if(customerList[i].getPhoneNumber().equals(customer.getPhoneNumber())) {
				return -2;
			}
		}
		customerList[countC] = new customer(customer);
		return countC + 1;
	}

	@Override
	public int sell(product[] productList, int count, customer[] customerList, int countC, salesHistory[] history,
			int countH, String productName, int amount, String phoneNumber) {
		if(productList == null || customerList == null || history == null) {
			return -1;
		}
		if(productList.length < count 
				|| customerList.length < countC 
				|| history.length <= countH) {
			return -1;
		}
		
		int productIndex = indexOf(productList, count, new product(productName));
		int customerIndex = indexOf(customerList, countC, phoneNumber);
		
		if(productIndex == -1 || customerIndex == -1) {
			return -1;
		}
		product sellProduct = new product(productList[productIndex]);
		sellProduct.setAmount(amount);
		
		salesHistory salesHistory = new salesHistory(customerList[customerIndex], sellProduct);
		
		history[countH] = salesHistory;
		return countH + 1;
	}

	private int indexOf(customer[] customerList, int countC, String phoneNumber) {
		if(customerList == null || phoneNumber == null) {
			return -1;
		}
		for(int i = 0; i < countC; i++) {
			if(customerList[i].getPhoneNumber().equals(phoneNumber)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public void printSales(salesHistory[] history, int countH) {
		int totalPrice = 0;
		for(int i = 0; i < countH; i++) {
			System.out.println("-------------");
			history[i].printHistory();
			totalPrice += history[i].getPrice();
		}
		
		System.out.println("Total sales figures : " + totalPrice);
		
	}
	
}
