package day8.practice;
import java.util.Scanner;

public class MethodLCMEx {

	public static void main(String[] args) {
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		System.out.println(lcm(num1, num2));
		
		
		sc.close();

	}
	
	public static boolean mod(int a, int b) {
		return a % b == 0;
	}
	
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
	
	public static int gcd(int a, int b) {
		for(int i = a; i >= 2; i--) {
			if(mod(b, i) && mod(a, i)) {
				return i;
			}
		}
		return 1;
	}

}
