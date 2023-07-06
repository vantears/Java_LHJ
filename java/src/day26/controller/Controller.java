package day26.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import day26.vo.Books;
import day26.vo.RentalHistory;

public class Controller {
	
	Scanner sc = new Scanner(System.in);
	private int menu;
	private int bookCount;
	private int index = 0;
	ArrayList <Books> list = new ArrayList<>();
	ArrayList <RentalHistory> history = new ArrayList<>();
	private static final int EXIT = 5;
	
	public void run() {
		load();
		loadHistory();
		loadIndex();
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);		
		} while(menu != EXIT);
		save();
		sc.close();
	}

	private void printMenu() {
		System.out.println("=============");
		System.out.println("Menu");
		System.out.println("1. Store books");
		System.out.println("2. Rent books");
		System.out.println("3. Return books");
		System.out.println("4. Rental History");
		System.out.println("5. Quit");
		System.out.print("Choose an option : ");
	}
	
	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			storeBooks();
			break;
		case 2:
			rentBooks();
			break;
		case 3:
			returnBooks();
			break;
		case 4:
			PrintHistory();
			break;
		case 5:
			System.out.println("Have a wise day!");
			break;
		default:
			System.out.println("Wrong option!");
		}
		
	}
	
	private void storeBooks() {
		sc.nextLine();
		System.out.print("Enter the book's title : ");
		String title = sc.nextLine();
		System.out.print("Entet the book's author : ");
		String author = sc.nextLine();
		index++;
		bookCount = 0;
		for(int i = 0; i < list.size(); i++) {
			if(title.charAt(0) == list.get(i).getTitle().charAt(0)) {
				bookCount++;
			}
		}
		list.add(new Books(title, author, ++bookCount));
		createIsbn(index);
		for(Books tmp : list) {
			System.out.println(tmp);
		}
		
	}

	private void rentBooks() {
		list.stream().filter(b -> !b.isRent()).forEach(b -> System.out.println(b));
		sc.nextLine();
		System.out.print("Enter the BOOK NO. to rent : ");
		String bookNo = sc.nextLine();
		for(Books tmp : list) {
			if(tmp.getNum().equals(bookNo) && !tmp.isRent()) {
				LocalDate now = LocalDate.now();
				String rentalDate = now.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
				String dueDate = now.plusDays(7).format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
				history.add(new RentalHistory(tmp, rentalDate, dueDate));
				tmp.setRent(true);
				System.out.println(tmp.getTitle() + " has to be returned by " + dueDate);
				return;
				}
			}
		System.out.println("Can't rent the book!");
		
	}
	
	private void returnBooks() {
		int beingRentCount = 0;
		for(Books tmp : list) {
			if(tmp.isRent()) {
				System.out.println(tmp);
				beingRentCount++;
			}
		}
		if(beingRentCount == 0) {
			System.out.println("No book is being rented yet!");
			return;
		}
		sc.nextLine();
		System.out.print("Enter the BOOK NO. to return : ");
		String returnMenu = sc.nextLine();
		for(Books tmp : list) {
			if(tmp.getNum().equals(returnMenu)) {
				for(RentalHistory tmp2 : history) {
					if(tmp2.getBook().getNum().equals(tmp.getNum()) && tmp2.getReturnDate() == null) {
						System.out.println(tmp.getTitle() + " has been returned");
						tmp.setRent(false);
						tmp2.setReturnDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
						return;
					}
				}
			}
		}
		System.out.println("No such book is on the list!");
		
	}
	
	private void PrintHistory() {
		for(RentalHistory tmp : history) {
			tmp.print();
		}
	}
	
	private void createIsbn(int bookCount) {
		int duplicateCount;
		while(true) {
			duplicateCount = 0;
			int isbn = (int)(Math.random() * (999999 - 100000 + 1) + 100000);			
			for(int i = 0; i < list.size(); i++) {
				if(isbn == list.get(i).getIsbn()) {
					duplicateCount++;
				}
			}
			if(duplicateCount == 0) {
				list.get(bookCount - 1).setIsbn(isbn);
				return;				
			}
		}
	}

	private void save() {
		try(FileOutputStream bookF = new FileOutputStream("src/day26/vo/bookList.txt");
			ObjectOutputStream bookO = new ObjectOutputStream(bookF);
			FileOutputStream historyF = new FileOutputStream("src/day26/vo/rentalHistory.txt");
			ObjectOutputStream historyO = new ObjectOutputStream(historyF);
			FileOutputStream indexF = new FileOutputStream("src/day26/vo/index.txt");){
				for(Books tmp : list) {
					bookO.writeObject(tmp);
				}
				for(RentalHistory tmp2 : history) {
					historyO.writeObject(tmp2);
				};
				indexF.write(index);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void load() {
		try(ObjectInputStream bookOI = new ObjectInputStream(new FileInputStream("src/day26/vo/bookList.txt"))) {
			while(true) {
				Books tmp = (Books)bookOI.readObject();
				list.add(tmp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No Book file to load!");
		} catch (EOFException e) {
			System.out.println("Book file loaded!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("No Book class is found!");
		}
	}
	
	private void loadHistory() {
		try(ObjectInputStream historyOI = new ObjectInputStream(new FileInputStream("src/day26/vo/rentalHistory.txt"))) {
			while(true) {
				RentalHistory tmp2 = (RentalHistory)historyOI.readObject();
				history.add(tmp2);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No History file to load!");
		} catch (EOFException e) {
			System.out.println("History file loaded!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("No History class is found!");
		}
	}
	
	private void loadIndex() {
		try(FileInputStream indexFI= new FileInputStream("src/day26/vo/index.txt")) {
			index = (int)indexFI.read();
		} catch (FileNotFoundException e) {
			System.out.println("No Index file to load!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
