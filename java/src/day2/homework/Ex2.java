package day2.homework;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		// determine the new scanner function
		 Scanner sc = new Scanner(System.in);
		 // ask the user to put 2 integers on the console
		System.out.println("Enter 2 integers.");
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
		
		String a = "mm";
		String b = "m";
		String c = new String("mm");
		String d = b + b;
		System.out.println(a);
		System.out.println(b);
		System.out.println(d);
		System.out.println(c);
		System.out.println(a == c);
		System.out.println(a.equals(c));
	 }
}
