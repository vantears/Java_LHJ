package day2.homework;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		 // determine the new scanner function
		 Scanner sc = new Scanner(System.in);
		 // ask the user to put 2 integers on the console
		System.out.println("두 정수를 입력하세요.");
		 // determine the variables
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int add = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = num1 / (double)num2;
		int mod = num1 % num2;
		 // print out the result on the console
		// System.out.println(num1 + " + " + num2 + " = " + add);
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		System.out.println(num1 + " - " + num2 + " = " + sub);
		System.out.println(num1 + " * " + num2 + " = " + mul);
		System.out.println(num1 + " / " + num2 + " = " + div);
		System.out.println("the leftover from " + num1 + " / " + num2 + " = " + mod);
		
		sc.close();
		
		
		
	 }
}
