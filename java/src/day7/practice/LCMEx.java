package day7.practice;
import java.util.Scanner;

public class LCMEx {

	public static void main(String[] args) {
		int a, b, i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two integers : ");
		a = sc.nextInt();
		b = sc.nextInt();
		
		//for loop
		for(i = a; ; i++) {
			if(i % a == 0 && i % b == 0) {
				System.out.println(i);
				break;
			}
		}

		//while loop
		i = a;
		while(true) {
			if( i % b == 0) {
				System.out.println(i);
				break;
			}
			i += a;
		}
		sc.close();
	}

}
