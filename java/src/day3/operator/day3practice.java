package day3.operator;
import java.util.Scanner;

public class day3practice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your score");
		int score = sc.nextInt();
		String result = score >= 60 ? "pass" : "fail";
		System.out.println("Do you pass with " + score + " points? " + result);
		sc.close();
	}
}
