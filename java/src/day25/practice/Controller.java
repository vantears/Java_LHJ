package day25.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	
	Scanner sc = new Scanner(System.in);
	private int menu;
	private ArrayList <Student> list = new ArrayList<>();
	private int listCount = 0;
	private static final int EXIT = 3;
	
	
	public void run() {
		do {
			menuPrint();
			menu = sc.nextInt();
			optionPrint(menu);
		} while(menu != EXIT);
		sc.close();
		
	}

	private void menuPrint() {
		System.out.println("------------------");
		System.out.println("Menu");
		System.out.println("1. Register a student");
		System.out.println("2. Search a student");
		System.out.println("3. Quit");
		System.out.println("------------------");
		System.out.print("Choose an option : ");
	}
	
	private void optionPrint(int menu) {
		switch(menu) {
		case 1:
			addStudent();
			break;
		case 2:
			searchStudent();
			break;
		case 3:
			System.out.println("Quitting!");
			break;
		default:
			System.out.println("Wrong option!");
		}
		
	}

	private void addStudent() {
		sc.nextLine();
		System.out.print("Enter the student's major : ");
		String major = sc.nextLine();
		System.out.print("Enter the student's name : ");
		String name = sc.nextLine();
		list.add(new Student(major, name));
		listCount++;
		System.out.println("Registered student ID : " + list.get(listCount - 1).getNum());
		System.out.println("Registered student Major : " + list.get(listCount - 1).getMajor());
		System.out.println("Registered student Name : " + list.get(listCount - 1).getName());
		
		
		
	}
	
	private void searchStudent() {
		System.out.print("Enter the student's ID : ");
		String num = sc.next();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(num)) {
				System.out.println("Student ID : " + list.get(i).getNum());
				System.out.println("Student Major : " + list.get(i).getMajor());
				System.out.println("Student Name : " + list.get(i).getName());
				return;
			}
		}
		System.out.println("There is no such student!");
		
	}

}
