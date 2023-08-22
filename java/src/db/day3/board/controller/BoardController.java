package db.day3.board.controller;

import java.util.Scanner;

import db.day3.board.service.BoardService;
import db.day3.board.service.BoardServiceImp;
import db.day3.board.vo.BoardVO;



public class BoardController {

	private BoardService boardService = new BoardServiceImp();
	Scanner sc = new Scanner(System.in);
	
	public void run() {
		int menu;
		final int EXIT = 5;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != EXIT);
	
	}

	private void printMenu() {
		System.out.println("=====POSTS=====");
		System.out.println("1. Upload a post");
		System.out.println("2. Modify a post");
		System.out.println("3. Delete a post");
		System.out.println("4. Search all posts");
		System.out.println("5. Go back");
		System.out.println("===============");
		System.out.print("Choose : ");
		
	}
	
	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertBoard();
			break;
		case 2:
			updateBoard();
			break;
		case 3:
			deleteBoard();
			break;
		case 4:
			selectAllBoard();
			break;
		case 5:
			System.out.println("[Going back]");
			break;
		default:
			System.out.println("[WRONG MENU!]");
		}
		
	}

	private void selectAllBoard() {
		boardService.selectAllBoard();
		
	}

	private void deleteBoard() {
		System.out.println("Post no : ");
		int num = sc.nextInt();
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();
		
		BoardVO board = new BoardVO(num, null, id);
		if(boardService.deleteBoard(board, pw)) {
			System.out.println("[Post deleted successfully!]");
		} else {
			System.out.println("[Failed to delete post!]");
		}
		
	}

	private void updateBoard() {
		System.out.println("Post no : ");
		int num = sc.nextInt();
		System.out.println("Post title : ");
		sc.nextLine();
		String title = sc.nextLine();
		
		BoardVO board = new BoardVO(num, title, null);
		if(boardService.updateBoard(board)) {
			System.out.println("[Post modified successfully!]");
		} else {
			System.out.println("[Failed to modify post!]");
		}
		//게시글 번호를 이용하여 게시글을 가져옴
		
		//게시글이 없으면 종료
		
		//있으면 게시글의 제목을 수정
		
		//DAO에게 게시글을 수정하라고 시킴
	}

	private void insertBoard() {
		//게시글 정보 입력(제목, 작성자 아이디)
		System.out.print("Title : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("ID : ");
		String id = sc.next();
		
		BoardVO board = new BoardVO(title, id);
		if(boardService.insertBoard(board)) {
			System.out.println("[Post uploaded successfully!]");
		} else {
			System.out.println("[Failed to upload post!]");
		}
		
	}
}
