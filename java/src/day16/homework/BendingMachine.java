package day16.homework;
import java.util.Scanner;

import java.util.ArrayList;

public class BendingMachine {
	
	int money = 0;
	Scanner sc = new Scanner(System.in);
	ArrayList<Baverage> baverage = new ArrayList<>();
	
	int countS;
	int countC;
	int countF;
	
	public void run() {
		baverage.add(new Baverage("Sprite", 500, 0));
		baverage.add(new Baverage("Coke", 600, 0));
		baverage.add(new Baverage("Fanta", 400, 0));
		int menu = 0;
		do {
			print();
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				insertMoney();
				break;
			case 2:
				selectBaverage();
				break;
			case 3:
				storeBaverage();
				break;
			case 4:
				System.out.println("Qutting!");
				break;
			default:
				System.out.println("Wrong option!");
			}
		}while(menu != 4);
		
		sc.close();

	}
	
	private void storeBaverage() {
		int menu, amount = 0;
		System.out.println("1. Sprite");
		System.out.println("2. Coke");
		System.out.println("3. Fanta");
		System.out.print("Choose baverage : ");
		menu = sc.nextInt();
		switch(menu) {
		case 1:
			
			System.out.print("How many Sprite do you store ? : ");
			amount = sc.nextInt();
			if(amount < 0) {
				System.out.println("Can't store a negative amount!");
				return;
			}
			baverage.get(0).store(amount);
			System.out.println(amount + " Sprite is(are) stored!");
			System.out.println(baverage.get(0).amount);
			break;
		case 2:
			System.out.print("How many Coke do you store ? : ");
			amount = sc.nextInt();
			if(amount < 0) {
				System.out.println("Can't store a negative amount!");
				return;
			}
			baverage.get(1).store(amount);
			System.out.println(amount + " Coke is(are) stored!");
			System.out.println(baverage.get(1).amount);
			break;
		case 3:
			System.out.print("How many Fanta do you store ? : ");
			amount = sc.nextInt();
			if(amount < 0) {
				System.out.println("Can't store a negative amount!");
				return;
			}
			baverage.get(2).store(amount);
			System.out.println(amount + " Fanta is(are) stored!");
			System.out.println(baverage.get(2).amount);
			break;
		default:
			System.out.println("Wrong baverage!");
		}
	}

	private void selectBaverage() {
		int menu = 0;
		System.out.println("1. Sprite");
		System.out.println("2. Coke");
		System.out.println("3. Fanta");
		System.out.print("Choose baverage : ");
		menu = sc.nextInt();
		switch(menu) {
		case 1:
			if(baverage.get(0).amount == 0) {
				System.out.println("Not enough Sprite is stored!");
				return;
			}
			if(money < baverage.get(0).price) {
				System.out.println("Not enough money is inserted!");
				return;
			}
			System.out.println("Sprite" + " is chosen");
			System.out.println("Sprite" + " is served");
			baverage.get(0).sellOut();
			money -= baverage.get(0).getPrice();
			System.out.println("Change $" + money + " is returned");
			money = 0;
			break;
		case 2:
			if(baverage.get(1).amount == 0) {
				System.out.println("Not enough Coke is stored!");
				return;
			}
			if(money < baverage.get(1).price) {
				System.out.println("Not enough money is inserted!");
				return;
			}
			System.out.println("Coke" + " is chosen");
			System.out.println("Coke" + " is served");
			baverage.get(1).sellOut();
			money -= baverage.get(1).getPrice();
			System.out.println("Change $" + money + " is returned");
			money = 0;
			break;
		case 3:
			if(baverage.get(2).amount == 0) {
				System.out.println("Not enough Fanta is stored!");
				return;
			}
			if(money < baverage.get(2).price) {
				System.out.println("Not enough money is inserted!");
				return;
			}
			System.out.println("Fanta" + " is chosen");
			System.out.println("Fanta" + " is served");
			baverage.get(2).sellOut();
			money -= baverage.get(2).getPrice();
			System.out.println("Change $" + money + " is returned");
			money = 0;
			break;
		default:
			System.out.println("Wrong baverage!");
		}
		
	}

	private void insertMoney() {
		int insert;
		System.out.print("How much money do you insert? : ");
		insert = sc.nextInt();
		money += insert;
		System.out.println("$" + money + " is inserted!");
		
	}

	public void print() {
		System.out.println("MENU");
		System.out.println("1. Insert money");
		System.out.println("2. Select baverage");
		System.out.println("3. Store baverage");
		System.out.println("4. Quit");
		System.out.print("Choose an option : ");
	}

}



