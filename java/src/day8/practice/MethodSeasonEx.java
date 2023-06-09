package day8.practice;
import java.util.Scanner;

public class MethodSeasonEx {

	public static void main(String[] args) {
		int month;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a month : ");
		month = sc.nextInt();
		monthCheck(month);
		System.out.println(monthCheck2(month));
		sc.close();

	}
	
	public static void monthCheck(int a) {
		switch(a) {
		case 3, 4, 5:
			System.out.println(a + " is Spring");
		    break;
		case 6, 7, 8:
			System.out.println(a + " is Summer");
		    break;
		case 9, 10, 11:
			System.out.println(a + " is Autumm");
		    break;
		case 12, 1, 2:
			System.out.println(a + " is Winter");
		    break;
		default:
			System.out.println("Wrong month!");
		
		}
	}
	
	public static String monthCheck2(int a) {
		if(a >= 3 && a < 6) {
			return "Spring";
		} else if(a >= 6 && a < 9) {
			return "Summer";
		} else if(a >= 9 && a < 12) {
			return "Autumm";
		} else if(a == 12 || a == 1 || a == 2) {
			return "Winter";
		} else {
			return "Wrong month!";
		}
	}

}
