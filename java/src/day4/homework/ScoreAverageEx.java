package day4.homework;
import java.util.Scanner;

public class ScoreAverageEx {

	public static void main(String[] args) {
		/*국어, 영어, 수학 성적을 입력받아 평균을 출력하는 코드를 작성하세요.
		  (package : day4.homework, file : ScoreAverageEx)
		  성적은 정수.
		*/
		int lang, eng, math;
		double avg;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Language, English, Mathmetics scores : ");
		lang = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		avg = (lang + eng + math) / (double) 3.0;
		System.out.println(avg);
		sc.close();
	}

}
