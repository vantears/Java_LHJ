package day6.practice;
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
		
		int min, max;
		int check = 0;
		char play = 'y';
		Scanner sc = new Scanner(System.in);
		while(play == 'y') {
			System.out.println("Enter min and max of random number : ");
			min = sc.nextInt();
			max = sc.nextInt();
			int i = min - 1;
			int random = (int)(Math.random() * (max - min + 1) + min);
			System.out.println("Guess the random number : ");
			while(random != i) {
				i = sc.nextInt();
				if (i == random) {
					System.out.println("Good!");
					System.out.println("Play again?(y/n) : ");
					do {
						play = sc.next().charAt(0);
						if(play != 'y' && play != 'n') {
							System.out.println("Please enter y or n");
							check = 1;
							} else {
								check = 0;
								}
						}  while(check == 1);
					} else if(i > random) {
						System.out.println("Down!");
						} else {
							System.out.println("Up!");
							}
				}
			}
		sc.close();
		}

}
