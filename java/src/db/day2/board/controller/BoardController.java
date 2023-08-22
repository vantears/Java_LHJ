package db.day2.board.controller;

import java.sql.Connection;
import java.util.Scanner;

public class BoardController {
	
	private Connection con;
	private Scanner sc;

	public BoardController(Connection con, Scanner sc) {
		this.con = con;
		this.sc = sc;
	}

	public void run() {
		int menu;
		final int EXIT = 3;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != EXIT);
	}

	private void runMenu(int menu) {
		// TODO Auto-generated method stub
		
	}

	private void printMenu() {
		// TODO Auto-generated method stub
		
	}

}
