package day6.homework;
import java.util.Scanner;

public class DisJointEx {

	public static void main(String[] args) {
		int x, y;
		int i = 2;
		int c = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two integer numbers : ");
		x = sc.nextInt();
		y = sc.nextInt();
		while(i <= x || i <= y) {
			if(x % i == 0 && y % i == 0) {
				c++;
				break;
			}
			i++;
		}
		switch(c) {
		case 0:
			System.out.println("Disjoint!");
			break;
		default:
			System.out.println("Not disjoint!");
		}
		sc.close();

	}

}
