package day8.homework;
import java.util.Scanner;

public class MethodScoreEx {

	public static void main(String[] args) {
		int score;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your score : ");
		score = sc.nextInt();
		System.out.println(score(score));
		
		sc.close();

	}

	public static String score(int a) {
		if(a <= 100 && a > 90) {
			return "A";
		} else if(a <= 90 && a > 80) {
			return "B";
		} else if(a <= 80 && a > 70) {
			return "C";
		} else if(a <= 70 && a > 60) {
			return "D";
		} else if(a <= 60 && a > 0) {
			return "F";
		} else {
			return "Wrong score";
		}
	}
}
