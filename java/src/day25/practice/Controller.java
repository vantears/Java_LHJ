package day25.practice;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	
	Scanner sc = new Scanner(System.in);
	private int menu;
	private ArrayList <Student> list = new ArrayList<>();
	private int listCount = 0;
	private static final int EXIT = 3;
	
	
	public void run() {
		String fileName = "src/day25/practice/student.txt";
		load(fileName);
		do {
			menuPrint();
			menu = sc.nextInt();
			optionPrint(menu);
		} while(menu != EXIT);
		save(fileName);
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
			searchMenu();
			break;
		case 3:
			System.out.println("Quitting!");
			break;
		default:
			System.out.println("Wrong option!");
		}
		
	}
	
	private void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			FileOutputStream count = new FileOutputStream("src/day25/practice/count.txt");){
				for(Student tmp : list) {
					oos.writeObject(tmp);
				}
				count.write(listCount);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void load(String fileName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
			FileInputStream sCount = new FileInputStream("src/day25/practice/count.txt");) {
			int loadList = sCount.read();
			listCount = loadList;
			while(true) {
				Student tmp = (Student)ois.readObject();
				list.add(tmp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No file to load!");
		} catch (EOFException e) {
			System.out.println("File loaded!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("No Student class is found!");
		}
	}

	private void addStudent() {
		sc.nextLine();
		System.out.print("Enter the student's major : ");
		String major = sc.nextLine();
		System.out.print("Enter the student's name : ");
		String name = sc.nextLine();
		list.add(new Student(major, name, listCount));
		listCount++;
		System.out.println("Successfully registered!");
		
		
		
	}
	
	private void searchMenu() {
		System.out.println("1. Check all the students");
		System.out.println("2. Search a student");
		System.out.print("Choose an option : ");
		int searchMenu = sc.nextInt();
		switch(searchMenu) {
		case 1:
			printAllStudent();
			break;
		case 2:
			searchStudent();
			break;
		default:
			System.out.println("Wrong option!");
		}
		
	}
	
	private void printAllStudent() {
		for(Student tmp : list) {
			tmp.print();
		}
	}
	
	private void searchStudent() {
		System.out.print("Enter the student's ID : ");
		String num = sc.next();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum().equals(num)) {
				list.get(i).print();
				return;
			}
		}
		System.out.println("There is no such student!");
		
	}

}
