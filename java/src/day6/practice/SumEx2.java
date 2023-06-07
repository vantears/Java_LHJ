package day6.practice;
import java.util.Scanner;

public class SumEx2 {
	public static void main(String[] args) {
		int num;
		int i = 1;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an integer number : ");
		num = sc.nextInt();
		while(i <= num) {
			if(i % 2 == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println(sum);
		sc.close();
	}
}
