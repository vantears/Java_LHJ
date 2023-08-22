package db.day2.board.controller;

import java.sql.Connection;
import java.util.Scanner;

import db.day2.board.service.MemberService;
import db.day2.board.service.MemberServiceImp;

public class MemberController {

	private Connection con;
	private Scanner sc;
	private MemberService memberService;
	
	public MemberController(Connection con, Scanner sc) {
		this.con = con;
		this.sc = sc;
		memberService = new MemberServiceImp(con);
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
		switch(menu) {
		case 1:
			signUp();
			break;
		case 2:
			dismiss();
			break;
		case 3:
			break;
		default:
			System.out.println("[Wrong menu]");
		}
		
	}


	private void dismiss() {
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();
		if(memberService.dismiss(id, pw)) {
			System.out.println("[Dismiss successful!]");
		} else {
			System.out.println("[Dismiss failed!]");
		}	
	}

	private void printMenu() {
		System.out.println("=====Member=====");
		System.out.println("1. Sign up");
		System.out.println("2. Dismiss");
		System.out.println("3. Go back");
		System.out.println("================");
		System.out.print("Choose : ");
	}

	private void signUp() {
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();
		if(memberService.signUp(id, pw)) {
			System.out.println("[Sign up successful!]");
		} else {
			System.out.println("[Sign up failed!]");
		}	
	}
}
