package day22.practice;
import java.util.ArrayList;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class PhoneListEx {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<PhoneNum> list = new ArrayList<>();
	static final int EXIT = 4;

	public static void main(String[] args) {
		int menu = 0;
		do {
			printMenu();
			menu = sc.nextInt();
			selectMenu(menu);
			
		} while(menu != EXIT);
		sc.close();
	}
	
	public static void printMenu() {
		System.out.println("Menu");
		System.out.println("1. Add mew Phone number");
		System.out.println("2. Modify a phone number");
		System.out.println("3. Search a phone number");
		System.out.println("4. Exit");
		System.out.print("Choose an option : ");
	}
	
	public static void selectMenu(int menu) {
		switch(menu) {
		case 1:
			addPhone();
			break;
		case 2:
			modifyPhone();
			break;
		case 3:
			searchPhone();
			break;
		case 4:
			System.out.println("Quitting!");
			break;
		default: System.out.println("Wrong option!");
		}
	}
	
	public static void addPhone() {
		System.out.print("Enter the name : ");
		String name = sc.next();
		System.out.print("Enter the phone number : ");
		String number = sc.next();
		list.add(new PhoneNum(name, number));
	}
	
	public static void modifyPhone() {
		System.out.print("Enter the phone number : ");
		String number = sc.next();
		int index = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNumber().equals(number)) {
				System.out.println(list.get(i));
				index = i;
				break;
			}
		}
		System.out.print("Enter the new number : ");
		String newNumber = sc.next();
		list.get(index).setNumber(newNumber);
		
	}
	
	public static void searchPhone() {
		
	}

}

@Data
@AllArgsConstructor
class PhoneNum {
	String name;
	String number;
}