package day6.practice;
import java.util.Scanner;

public class AverageEx {

	public static void main(String[] args) {
		int kor, eng, math; 
		double avg;
		char stop = 'y';
		Scanner sc = new Scanner(System.in);
		while(stop == 'y') {
			System.out.println("Enter Kor, Eng, Math scores : ");
			kor = sc.nextInt();
			eng = sc.nextInt();
			math = sc.nextInt();
			avg = (kor + eng + math) / 3.0;
			System.out.println("Average is " + avg);
			System.out.println("Continue?(y/n)");
			stop = sc.next().charAt(0);
		}
		System.out.println("Exit!");
		sc.close();
	}

}
