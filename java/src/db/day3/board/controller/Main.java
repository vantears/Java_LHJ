package db.day3.board.controller;

import java.util.Scanner;

public class Main {

	private static MemberController memberController = new MemberController();
	private static BoardController boardController = new BoardController();
	
	public static void main(String[] args) {
		int menu;
		final int EXIT = 3;
		Scanner sc = new Scanner(System.in);
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != EXIT);
		sc.close();
	}


	private static void printMenu() {
		System.out.println("=====MENU=====");
		System.out.println("1. Manage accounts");
		System.out.println("2. Manage posts");
		System.out.println("3. Exit program");
		System.out.println("==============");
		System.out.print("Choose : ");
		
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			memberController.run();
			break;
		case 2:
			boardController.run();
			break;
		case 3:
			System.out.println("[Exiting program]");
			break;
		default:
			System.out.println("[WRONG MENU!]");
		}
		
	}
}
