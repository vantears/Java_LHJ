package day5.Practice;
import java.util.Scanner;

public class PrintMenuEx {

	public static void main(String[] args) {
		int sel = 0;
		Scanner sc = new Scanner(System.in);
		 while (sel != 3) {
			System.out.println(" ");
			System.out.println("Menu");
			System.out.println(" ");
			System.out.println("1. Start");
			System.out.println("2. Save");
			System.out.println("3. Exit");
			System.out.println(" ");
			System.out.println("Select menu : ");
			sel = sc.nextInt();
			switch (sel) {
			case 1:
				System.out.println("Program start!");
				break;
			case 2:
				System.out.println("Program save!");
				break;
			case 3:
				System.out.println("Program exit!");
				break;
			default:
				System.out.println("Wrong menu! choose again.");
			}
		}
		sc.close();

	}

}
