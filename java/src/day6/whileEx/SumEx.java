package day6.whileEx;
import java.util.Scanner;

public class SumEx {

	public static void main(String[] args) {
		int n;
		int i = 1;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter an integer number : ");
		n = sc.nextInt();
		while(i <= n) {
			sum += i;
			i++;
		}
		System.out.println(sum);
		sc.close();		
	}

}
