package day8.practice;
import java.util.Scanner;

public class MethodMultipleEx {

	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		num = sc.nextInt();
		isMultiple(num);
		sc.close();

	}
	
	public static void isMultiple(int a) {
		int six = 6, three = 3, two = 2;
		if(mod(a, six)) {
			System.out.println(a + " is a multiple of " + six); 
		} else if(mod(a, three)) {
			System.out.println(a + " is a multiple of " + three);
		} else if(mod(a, two)) {
			System.out.println(a + " is a multiple of " + two);
		} else {
			System.out.println(a + " is a prime number");
		}
	}
	
	public static boolean mod(int a, int b) {
		return a % b == 0;
	}
}
