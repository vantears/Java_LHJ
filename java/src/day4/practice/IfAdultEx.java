package day4.practice;
import java.util.Scanner;

public class IfAdultEx {

	public static void main(String[] args) {
		
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age: ");
		age = sc.nextInt();
		if (age >= 20) {
		System.out.println("Adult");
	} 
		 else {
		System.out.println("Minor");
  }
		sc.close();
 }
}