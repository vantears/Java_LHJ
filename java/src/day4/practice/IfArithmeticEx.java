package day4.practice;
import java.util.Scanner;

public class IfArithmeticEx {
	
	public static void main(String[] args) {
		
		int num1, num2;
		char op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an arithmetic equation: ");
		while (true) {
		num1 = sc.nextInt();
		op = sc.next().charAt(0);
		num2 = sc.nextInt();
		if (op == '+') {
			System.out.println(num1 + " " + op + " " + num2 + " = " + (num1 + num2));
			sc.close();
			break;
		} else if (op == '-') {
			System.out.println(num1 + " " + op + " " + num2 + " = " + (num1 - num2));
			sc.close();
			break;
		} else if (op == '*') {
			System.out.println(num1 + " " + op + " " + num2 + " = " + (num1 * num2));
			sc.close();
			break;
		} else if (op == '/') {
			System.out.println(num1 + " " + op + " " + num2 + " = " + (num1 / num2));
			sc.close();
			break;
		} else if (op == '%') {
			System.out.println(num1 + " " + op + " " + num2 + " = " + (num1 % num2));
			sc.close();
			break;
		} else {
			System.out.println("the operator is wrong. try again");
			continue;
		}
		}
		}
	}
