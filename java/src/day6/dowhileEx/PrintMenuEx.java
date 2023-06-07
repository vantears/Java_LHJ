package day6.dowhileEx;
import java.util.Scanner;

public class PrintMenuEx {

	public static void main(String[] args) {
		int menu;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("menu");
			System.out.println("1. Start");
			System.out.println("2. Save");
			System.out.println("3. Exit");
			System.out.println("Select menu : ");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println("Start!");
				break;
			case 2:
				System.out.println("Save!");
				break;
			case 3:
				System.out.println("Exit!");
				break;
			default:
				System.out.println("Wrong menu!");
			}
			
		} while(menu != 3);
		
		sc.close();

	}

}
