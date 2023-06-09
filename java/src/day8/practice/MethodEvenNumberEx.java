package day8.practice;
import java.util.Scanner;

public class MethodEvenNumberEx {

	public static void main(String[] args) {
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		a = sc.nextInt();
		even(a);
		
		if(mod(a) == 0) {
			System.out.println(a + " is an even number!");
		} else {
			System.out.println(a + " is an odd number!");
		}
		
		if(isEvenNumber(a)) {
			System.out.println(a + " is an even number!");
		} else {
			System.out.println(a + " is an odd number!");
		}
		
		if(isMultiple(a, 2)) {
			System.out.println(a + " is an even number!");
		} else {
			System.out.println(a + " is an odd number!");
		}
		sc.close();

	}
	
	
	public static void even(int a) {
		if(a % 2 == 0) {
			System.out.println(a + " is an even number!");
		} else {
			System.out.println(a + " is an odd number!");
		}
	}
	
	public static int mod(int a) {
		return a % 2;
	}

	public static boolean isEvenNumber(int a) {
		return a % 2 == 0;
	}
	
	public static boolean isMultiple(int a, int b) {
		return a % b == 0;
	}
}
