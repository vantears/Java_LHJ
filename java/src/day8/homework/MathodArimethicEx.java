package day8.homework;
import java.util.Scanner;

public class MathodArimethicEx {

	public static void main(String[] args) {
		int num1, num2;
		char op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers with an operator : ");
		num1 = sc.nextInt();
		op = sc.next().charAt(0);
		num2 = sc.nextInt();
		System.out.println(arithmetic(num1, num2, op));
		sc.close();

	}

	public static int arithmetic(int a, int b, char c) {
		if(c == '+') {
			return a + b;
		} else if(c == '-') {
			return a - b;
		} else if(c == '*') {
			return a * b;
		} else if(c == '/') {
			return a / b;
		} else if(c == '%') {
			return a % b;
		} else {
			return 0;
		}
	}
}
