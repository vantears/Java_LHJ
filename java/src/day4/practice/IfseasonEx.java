package day4.practice;
import java.util.Scanner;

public class IfseasonEx {

	public static void main(String[] args) {
		
		int month;
		String month2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a month: ");
		
		while (true) { 
			month = sc.nextInt();
			if ((month % 10) == 1) {
				month2 = month + "st";
			} else if ((month % 10) == 2) {
				month2 = month + "nd";
			} else if ((month % 10) == 3) {
				month2 = month + "rd";
			} else {
				month2 = month + "th";
			}
		if (month == 3 || month == 4 || month == 5) {
			System.out.println(month2 + " month is spring");
			sc.close();
			break;
		} else if (month == 6 || month == 7 || month == 8) {
			System.out.println(month2 + " month is summer");
			sc.close();
			break;
		} else if (month == 9 || month == 10 || month == 11) {
			System.out.println(month2 + " month is fall");
			sc.close();
			break;
		} else if (month == 12 || month == 1 || month == 2) {
			System.out.println(month2 + " month is winter");
			sc.close();
			break;
		} else {
			System.out.println(month2 + " month is wrong.");
			System.out.println("Please try again");
			continue;
		}
	}
	}

}
