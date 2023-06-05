package day5.switchEx;
import java.util.Scanner;

public class SeasonEx {

	public static void main(String[] args) {
		
		int month;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a month : ");
		month = sc.nextInt();
		switch(month) {
		case 3: case 4: case 5:
			System.out.println("Spring");
			break;
		case 6: case 7: case 8:
			System.out.println("Summer");
			break;
		case 9: case 10: case 11:
			System.out.println("Atumm");
			break;
		case 12: case 1: case 2:
			System.out.println("Winter");
			break;
		default:
			System.out.println("It is a wrong month!");
		}
		sc.close();
	}

}
