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
		
		double res = arithmetic(num1, num2, op);
		
		System.out.println(num1 + " " + op + " " + num2 + " = " + res);
		sc.close();

	}

	public static double arithmetic(int a, int b, char c) {
		double res = 0.0;
		if(c == '+') {
			res = a + b;
		} else if(c == '-') {
			res = a - b;
		} else if(c == '*') {
			res = a * b;
		} else if(c == '/') {
			res =  a / (double)b;
		} else if(c == '%') {
			res = a % b;
		}
		return res;
	}
}
