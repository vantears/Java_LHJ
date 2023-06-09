package day8.homework;
import java.util.Scanner;

public class MethodPrintCharEx {

	public static void main(String[] args) {
		int a;
		char b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number and a character : ");
		a = sc.nextInt();
		b = sc.next().charAt(0);
		printChar(a, b);
		
		sc.close();

	}

	public static void printChar(int a, char b) {
		for(int i = 1; i <= a; i++) {
			System.out.print(b);
		}
	}
}
