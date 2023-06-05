package day5.homework;
import java.util.Scanner;

public class UpDownEx {

	public static void main(String[] args) {
		/*UpDown게임
		1~100사이의 랜덤한 정수를 생성하고, 이 정수를 맞추는 게임을 구현하세요.
		(package : day5.homework, file : UpDownEx)
		랜덤한 수 : 45
		input : 50
		Down!
		input : 40
		Up!
		input : 45
		Good!*/
		
		int i, min, max;
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter min and max of random number : ");
		min = sc.nextInt();
		max = sc.nextInt();
		int random = (int)(Math.random() * (max - min + 1) + min);

		System.out.println("Guess the random number : ");
		while(answer != 1) {
			i = sc.nextInt();
			if (i == random) {
				System.out.println("Good!");
				answer = 1;
			} else if(i > random) {
				System.out.println("Down!");
			} else {
				System.out.println("Up!");
			}
		}
		
		sc.close();
		
		

	}

}
