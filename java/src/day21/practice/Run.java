package day21.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Run {
	private static final int EXIT = 3;
	private Scanner sc = new Scanner(System.in);
	private ArrayList<RandomNum> randomNum = new ArrayList<>();
	
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
		int user;
		int count = 0;
		System.out.print("Guess the random number (1 to 100) : ");
		System.out.println(r);
		do {
			user = sc.nextInt();
			if(user == r) {
				System.out.println("Correct!");
			} else if(user > r) {
				System.out.println("Down!");
			} else {
				System.out.println("Up!");
			}
			count++;
		}while(user != r);
		
		System.out.print("Record Id : ");
		String id = sc.next();
		randomNum.add(new RandomNum(id, count));
		randomNum.sort((RandomNum o1, RandomNum o2)->o1.getTryCount() - o2.getTryCount());
	}
	
	private void record() {
		int i = 1;
		for(RandomNum tmp : randomNum) {
			System.out.println(i + ". " + tmp.getId() + " : " + tmp.getTryCount());
			i++;
		}
	}
	
	/*private void sort(ArrayList<RandomNum> randomNum) {
		for(int i =0; i < randomNum.size() - 1; i++) {
			for(int j = 0; j < randomNum.size() - 1 - i; j++) {
				if(randomNum.get(j).getTryCount() > randomNum.get(j + 1).getTryCount()) {
					RandomNum tmp = randomNum.get(j);
					randomNum.set(j, randomNum.get(j + 1));
					randomNum.set(j + 1, tmp);
				}
			}
		}
	}*/
}
