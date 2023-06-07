package day6.practice;
import java.util.Scanner;

public class GCDEx {

	public static void main(String[] args) {
		int a, b;
		int div = 0;
		int i = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two integer numbers : ");
		a = sc.nextInt();
		b = sc.nextInt();
		while(i <= a || i <= b) {
			if(a % i == 0 && b % i == 0) {
				div = i;
			}
			i++;
		}
		System.out.println(div);
		sc.close();
	}

}
