package day4.practice;
import java.util.Scanner;

public class IfMultipleEx1 {

	public static void main(String[] args) {
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		num = sc.nextInt();
		if ((num % 2) == 0 && num != 0) {
			System.out.println(num + " is a multiple of 2");
		} else {
			System.out.println(num + " is not a multiple of 2");
		}
		sc.close();
	}

}
