package db.day3.board.controller;

import java.util.Scanner;

import db.day3.board.service.MemberService;
import db.day3.board.service.MemberServiceImp;
import db.day3.board.vo.MemberVO;

public class MemberController {

	private MemberService memberService = new MemberServiceImp();
	Scanner sc = new Scanner(System.in);

	public void run() {
		int menu;
		final int EXIT = 3;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != EXIT);
		
	}


	private void printMenu() {
		System.out.println("=====ACCOUNT=====");
		System.out.println("1. Create an account");
		System.out.println("2. Delete an account");
		System.out.println("3. Go back");
		System.out.println("=================");
		System.out.print("Choose : ");
		
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			signup();
			break;
		case 2:
			dismiss();
			break;
		case 3:
			System.out.println("[Going back]");
			break;
		default:
			System.out.println("[WRONG MENU!]");
		}
		
	}


	private void dismiss() {
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();
		
		MemberVO member = new MemberVO(id, pw);
		if(memberService.dismiss(member)) {
			System.out.println("[Account deleted successfully!]");
		}else {
			System.out.println("[Failed to delete the account!]");
		};
	}


	private void signup() {
		System.out.print("ID         : ");
		String id = sc.next();
		System.out.print("PW         : ");
		String pw = sc.next();
		System.out.print("CONFRIM PW : ");
		String pw2 = sc.next();
		//비번 확인하는 코드
		if(!pw.equals(pw2)) {
			System.out.println("[PASSWORD ERROR!]");
			return;
		}
		MemberVO member = new MemberVO(id,pw);
		if(memberService.signup(member)) {
			System.out.println("[Account created successfully!]");
		}else {
			System.out.println("[Failed to create an account!]");
		};
	}
}
