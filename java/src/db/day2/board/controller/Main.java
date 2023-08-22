package db.day2.board.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	private static Connection con = null;
	private static MemberController memberController;
	private static BoardController boardController;
	
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/test";
		String dbId = "root";
		String dbPw = "root";
		
		con = connect(url, dbId, dbPw);
		if(con != null) {
			System.out.println("[Connection succeeded!]");
		} else {
			System.out.println("[Connection failed!]");
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		int menu;
		final int EXIT = 3;
		memberController = new MemberController(con, sc);
		boardController = new BoardController(con, sc);
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu);
			
		}while(menu != EXIT);
		
		sc.close();
		close(con);
	}
	
	private static Connection connect(String url, String id, String pw) {
		try {
			return DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			return null;
		}
	}
	
	private static void close(Connection con) {
		try {
			if(con !=null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {}
	}
	
	private static void printMenu() {
		System.out.println("=====Menu=====");
		System.out.println("1. Member");
		System.out.println("2. Board");
		System.out.println("3. Exit");
		System.out.println("==============");
		System.out.print("Choose : ");
	}
	
	private static void runMenu(int menu) {
		switch(menu){
		case 1:
			memberController.run();
			break;
		case 2:
			boardController.run();
			break;
		case 3:
			System.out.println("[Program quit]");
			break;
		default:
			System.out.println("[Wrong menu]");
		}
	}

}
