package day5.Practice;
import java.util.Scanner;

public class PrimeNumberEx {

	public static void main(String[] args) {
		int num;
		int i = 1;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		num = sc.nextInt();
		
		while(i <= num) {
			if(num % i == 0) {
				count++;
			}
			i++;
		}
		
		// switch
		switch(count) {
		case 2:
			System.out.println(num + " is a prime number.");
			break;
		default:
			System.out.println(num + " is not a prime number.");
		}
		
		//if
		if(count == 2) {
			System.out.println(num + " is a prime number.");
		} else {
			System.out.println(num + " is not a prime number.");
		}
		
		//Ex2
		i = 2;
		while(i < num) {
			if(num % i == 0) {
				System.out.println(num + " is not a prime number.");
				break;
			}
			i++;
			if(i == num) {
				System.out.println(num + " is a prime number.");
			}
		}
		sc.close();
	}

}
