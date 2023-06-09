package day17.practice.controller;
import day17.practice.service.*;
import java.util.Scanner;
import day17.practice.vo.*;

public class shopController {
	
	Scanner sc = new Scanner(System.in);
	private product productList[] = new product[10];
	private customer customerList[] = new customer[10];
	private salesHistory history[] = new salesHistory[100];
	private int count = 0;
	private int countC = 0;
	private int countH = 0;
	
	private ShopService shopService= new ShopServiceImp();
	
	public void run() {
		
		int menu = 0;
		
		do {
			printMenu();//print the menu list.
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != 6);
		
		sc.close();
	}
	
	private void printMenu() {
		System.out.println("=========================");
		System.out.println("-MENU-");
		System.out.println("1. Sell products.");
		System.out.println("2. Store new products.");
		System.out.println("3. Search products");
		System.out.println("4. Check the sales figures");
		System.out.println("5. Register a customer");
		System.out.println("6. Quit");
		System.out.print("Choose an option in the menu : ");
	}
	
	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			System.out.print("Product : ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Amount : ");
			int amount = sc.nextInt();
			System.out.print("Customer's phone number: ");
			sc.nextLine();
			String phoneNumber = sc.nextLine();
	
			int salesCount = shopService.sell(
								productList, count, 
								customerList, countC, 
								history, countH,
								productName, amount, phoneNumber);
			if(salesCount == -1) {
				System.out.println("Failed to sell");
			} else {
				System.out.println("Successfully sold!");
				countH = salesCount;
			}
			break;
		case 2:
			product product = inputStoreProduct();
			count = shopService.store(productList, count, product);
			break;
		case 3:
			//Enter the product name
			System.out.print("Enter the product name : ");
			sc.nextLine();
			String search = sc.nextLine();
			//Search and print the product details
			shopService.printProduct(productList, count, search);
			break;
		case 4:
			shopService.printSales(history, countH);
			break;
		case 5:
			customer customer = inputRegisterCustomer();
			
			int count = shopService.registerCustomer(customerList, countC, customer);
			if(count == -1) {
				System.out.println("Failed to register!");
				} else if(count == -2) {
					System.out.println("The customer is already in the membership!");
					} else {				
						countC = count;
						printCustomerList();
						}
			break;
		case 6:
			System.out.println("Quitting the program!");
			break;
		default :
			System.out.println("Wrong option!");
		}
	}
	
	private product inputStoreProduct() {
		
		System.out.print("Enter the product name : ");
		sc.nextLine();
		String productName = sc.nextLine();
		System.out.print("Enter the amount : ");
		int amount = sc.nextInt();
		if(amount < 0) {
			System.out.println("The amount to store is wrong!");
			return null;
		}
		int index = indexOf(productName);
		if(index != -1) {
			product product = new product(productList[index]);
			product.setAmount(amount);
			return product;
		}
		if(count == productList.length) {
			System.out.println("The storage is full!");
			return null;
		}
		System.out.println("Store new product");
		System.out.print("Model name : ");
		sc.nextLine();
		String modelName = sc.nextLine();
		System.out.print("Price : ");
		int price = sc.nextInt();
		System.out.print("Category : ");
		String category = sc.next();
		
		product product = new product(productName, modelName, price, amount, category);
		return product;
		
	}
	
	private customer inputRegisterCustomer() {
		System.out.print("Enter the customer's name : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Enter the phone number : ");
		String phoneNumber = sc.next();
		return new customer(name, phoneNumber);
	}
	
	public int indexOf(String name) {
		for(int i = 0; i < count; i++) {
			if(productList[i].getProductName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public int indexOfC(String phoneNumber) {
		for(int i = 0; i < countC; i++) {
			if(customerList[i].getPhoneNumber().equals(phoneNumber)) {
				return i;
			}
		}
		return -1;
	}
	
	public void printCustomerList() {
		if(countC == 0) {
			System.out.println("No customer is registered yet!");
			return;
		}
		for(int i = 0; i < countC; i++) {
			customerList[i].print();
		}
	}

}
