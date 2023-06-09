package day8.homework;
import java.util.Scanner;

public class MathodMonthEx {

	public static void main(String[] args) {
		int month;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a month : ");
		month = sc.nextInt();
		System.out.println(month(month));
		
		sc.close();

	}

	public static String month(int a) {
		switch(a) {
		case 1:
			return "January";
		case 2:
			return "Febuary";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			return "Wrong month!";
		}
	}
}
