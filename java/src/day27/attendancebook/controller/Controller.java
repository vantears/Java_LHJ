package day27.attendancebook.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import day27.attendancebook.vo.Attendance;
import day27.attendancebook.vo.Student;

public class Controller {
	Scanner sc = new Scanner(System.in);
	private int menu;
	
	private ArrayList<Student> students = new ArrayList<>();
	private ArrayList<Attendance> history = new ArrayList<>();
	
	
	public void run() {
		try {
			do {
				printMenu();
				menu = sc.nextInt();
				runMenu(menu);
				
			} while(menu != 4);			
		} catch(Exception e) {
		System.out.println("Exception!");
		}
	}

	private void printMenu() {
		System.out.println("==========");
		System.out.println("Menu");
		System.out.println("1. Register a student");
		System.out.println("2. Attend");
		System.out.println("3. Check the attendance history");
		System.out.println("4. Quit program");
		System.out.print("Choose an option : ");
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			addStudent();
			break;
		case 2:
			attend();
			break;
		case 3:
			attendanceHistory();
			break;
		case 4:
			System.out.println("Have a nice day!");
			break;
		default:
			System.out.println("Wrong option!");
		}
		
	}

	private void addStudent() {
		sc.nextLine();
		System.out.print("Enter the student's name : ");
		String name = sc.nextLine();
		for(Student tmp : students) {
			if(tmp.getName().equals(name)) {
				System.out.println("The student is already registered!");
				return;
			}
		}
		students.add(new Student(name));
		System.out.println(students);
		
		
	}

	private void attend() {
		sc.nextLine();
		System.out.println("Enter the student's name : ");
		String name = sc.nextLine();
		LocalDate now = LocalDate.now();
		String attendTime = now.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
		for(Student tmp : students) {
			if(tmp.getName().equals(name)) {
				for(Attendance tmp2 : history) {
					if(tmp2.getDate().equals(attendTime)) {
						if(tmp2.getStudents().contains(tmp)) {
							tmp2.attendStudent(tmp);
							return;							
						}
						tmp2.addStudent(tmp);
						tmp2.attendStudent(tmp);
						return;
					}
				}
				history.add(new Attendance(attendTime, students, tmp));
				return;				
			}
			
		}
		System.out.println("No such student is found!");
	}

	private void attendanceHistory() {
		for(Attendance tmp : history) {
			tmp.print();
		}
		
	}
}
