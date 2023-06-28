package day21.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
	private static final int EXIT = 3;
	private Scanner sc = new Scanner(System.in);
	private ArrayList<RandomNum> randomNum = new ArrayList<>();
	private int numCount = 0;
	
	public void run() {
		int menu;
		do {
			System.out.println("Menu");
			System.out.println("1. Play");
			System.out.println("2. Record");
			System.out.println("3. Exit");
			System.out.print("Choose an option : ");
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != EXIT);
		
		sc.close();
	}
	
	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			play();
			break;
		case 2:
			record();
			break;
		case 3:
			System.out.println("Program exit!");
			break;
		default:
			System.out.println("Wrong menu!");
		}
	}
	
	private void play() {
		int r = (int)(Math.random() * 100 + 1);
		randomNum.add(new RandomNum());
		numCount++;
		int user;
		System.out.print("Guess the random number (1 to 100) : ");
		do {
			user = sc.nextInt();
			if(user == r) {
				System.out.println("Correct!");
				randomNum.get(numCount -1).addTryCount();
			} else if(user > r) {
				System.out.println("Down!");
				randomNum.get(numCount -1).addTryCount();
			} else {
				System.out.println("Up!");
				randomNum.get(numCount -1).addTryCount();
			}
		}while(user != r);
		
		System.out.print("Record Id : ");
		String id = sc.next();
		randomNum.get(numCount-1).setId(id);
	}
	
	private void record() {
		int i = 1;
		for(RandomNum tmp : randomNum) {
			System.out.println(i + ". " + tmp.getId() + " : " + tmp.getTryCount());
			i++;
		}
	}
}
