package day17.practice.service;

import day17.practice.vo.customer;
import day17.practice.vo.product;
import day17.practice.vo.salesHistory;

public interface ShopService {

	int store(product[] productList, int count, product product);

	void printProduct(product[] productList, int count, String search);

	int registerCustomer(customer[] customerList, int countC, customer customer);

	int sell(product[] productList, int count, customer[] customerList, int countC, salesHistory[] history, int countH,
			String productName, int amount, String phoneNumber);

	void printSales(salesHistory[] history, int countH);
	
}
