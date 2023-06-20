package day15.practice.shop.controller;

import java.util.Scanner;
import day15.practice.shop.product.*;

public class shopManager {
	
	Scanner sc = new Scanner(System.in);
	private product productList[] = new product[10];
	private customer customerList[] = new customer[10];
	private int count = 0;
	private int countC = 0;
	
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
			sellSubMenu();
			break;
		case 2:
			storeSubMenu();
			break;
		case 3:
			searchSubMenu();
			break;
		case 4:
			salesSubMenu();
			break;
		case 5:
			registerSubMenu();
			break;
		case 6:
			System.out.println("Quitting the program!");
			break;
		default :
			System.out.println("Wrong option!");
		}
	}
	
	private String printProduct(int product) {
		switch(product) {
		case 1:
			return "TV";
		case 2:
			return "Airconditioner";
		case 3:
			return "Radio";
		}
		return "";
	}
	
	private void sellSubMenu() {
		String name;
		String productName;
		int quantity;
		System.out.print("Enter the customer name to sell to: ");
		sc.nextLine();
		name = sc.nextLine();
		int indexC = indexOfC(name);
		if(indexC == -1) {
			System.out.println("No such customer is found!");
			return;
		}
		System.out.print("Enter the product name to sell : ");
		productName = sc.nextLine();
		int index = indexOf(productName);
		if(index == -1) {
			System.out.println("No such product is stored!");
			return;
		}
		System.out.print("How many of the product is going to be sold? : ");
		quantity = sc.nextInt();
		if(quantity < 0) {
			System.out.println("The amount is not correct!");
			return;
		}
		productList[index].sellOut(quantity);
		
	}
	
	private void storeSubMenu() {
		String productName;
		int amount;
		System.out.print("Enter the product name : ");
		sc.nextLine();
		productName = sc.nextLine();
		System.out.print("Enter the amount : ");
		amount = sc.nextInt();
		if(amount < 0) {
			System.out.println("The amount to store is wrong!");
			return;
		}
		int index = indexOf(productName);
		if(index != -1) {
			productList[index].store(amount);
			productList[index].printProduct();
			return;
		}
		if(count == productList.length) {
			System.out.println("The storage is full!");
			return;
		}
		System.out.println("Store new product");
		System.out.print("Model name : ");
		sc.nextLine();
		String modelName = sc.nextLine();
		System.out.print("Price : ");
		int price = sc.nextInt();
		System.out.print("Category : ");
		String category = sc.next();
		productList[count] = new product(productName, modelName, price, amount, category);
		productList[count].printProduct();
		count++;

		
		
	}
	
	private void searchSubMenu() {
		String productName;
		System.out.print("Enter the product name : ");
		productName = sc.next();
		int index = indexOf(productName);
		if(index != -1) {
			productList[index].printProduct();
			return;
		}
		System.out.println("No such product is stored!");
	}
	private void salesSubMenu() {
		
	}
	private void registerSubMenu() {
		String name;
		System.out.print("Enter the customer's name : ");
		sc.nextLine();
		name = sc.nextLine();
		int index = indexOfC(name);
		if(index != -1) {
			System.out.println("The customer is already registered!");
			return;
		}
		customerList[countC] = new customer(name);
		countC++;
		printCustomerList();
	}
	
	public int indexOf(String name) {
		for(int i = 0; i < count; i++) {
			if(productList[i].getProductName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public int indexOfC(String name) {
		for(int i = 0; i < countC; i++) {
			if(customerList[i].getName().equals(name)) {
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
			System.out.println((i + 1) + ". custmoer");
			System.out.println("Name : " + customerList[i].getName());
		}
	}

}
