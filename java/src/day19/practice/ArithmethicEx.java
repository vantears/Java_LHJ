package day19.practice;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmethicEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc) {
		System.out.println("Enter two integers with an operator: ");
		int num1 = sc.nextInt();
		char op = sc.next().charAt(0);
		int num2 = sc.nextInt();
		operation(num1, op, num2);
		} catch(ArithmeticException e) {
			System.out.println("Can't operate!");
		} catch(InputMismatchException e) {
			System.out.println("Wrong input!");
		} catch(Exception e) {
			System.out.println("Unknown error!");
		}
		test1();
		test2();
		
	}
	
	public static void operation(int num1, char op, int num2) {
		switch(op) {
		case '+':
			System.out.println(num1 + " " + op + " " + num2 + " = " + (num1 + num2));
			break;
		case '-':
			System.out.println(num1 + " " + op + " " + num2 + " = " + (num1 - num2));	
			break;
		case '*':
			System.out.println(num1 + " " + op + " " + num2 + " = " + (num1 * num2));
			break;
		case '/':
			System.out.println(num1 + " " + op + " " + num2 + " = " + ((double)num1 / num2));
			break;
		case '%':
			System.out.println(num1 + " " + op + " " + num2 + " = " + (num1 % num2));	
			break;
		default:
			System.out.println("Wrong operator!");
			}
		
	}
	
	public static void test1() {
		try {
			System.out.println(1/0);
		} catch(Exception e) {
			System.out.println("Exception!");
			return;
		} finally {
			System.out.println("Method1 Exit!");
		}
	}
	
	public static void test2() {
		try {
			System.out.println(1/0);
		} catch(Exception e) {
			System.out.println("Exception!");
			return;
		}
		System.out.println("Method2 Exit!");
	}

}
