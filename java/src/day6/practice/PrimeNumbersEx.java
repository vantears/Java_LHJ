package day6.practice;
import java.util.Scanner;

public class PrimeNumbersEx {

	public static void main(String[] args) {
		int x, y, i, j, prime;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two integers : ");
		x = sc.nextInt();
		y = sc.nextInt();
		for(i = x; i <= y; i++) {
			prime = 0;
			for(j = 1; j <= i; j++) {
				if(i % j == 0) {
					prime++;
				}
			}
			if(prime == 2) {
			System.out.println(i);
		}
		}
		
		sc.close();

	}

}
