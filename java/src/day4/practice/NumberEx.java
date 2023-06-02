package day4.practice;
import java.util.Scanner;

public class NumberEx {

	public static void main(String[] args) {
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		num = sc.nextInt();
		if (num > 0) {
			System.out.println(num + " is a positive number");
		} else if (num < 0) {
			System.out.println(num + " is a negative number");
		} else {
			System.out.println(num + " is a zero");
		}
		sc.close();
	}

}
