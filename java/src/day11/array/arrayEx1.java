package day11.array;
import java.util.Scanner;

public class arrayEx1 {
	public static void main(String[] args) {
		/* 학생들의 국어 성적을 저장하기 위한 배열을 생성하세요.
		 * 학생들은 총 10명.
		 */
		int length;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		length = sc.nextInt();
		double [] studentKorScore = new double[length];
		for(int i = 0; i < studentKorScore.length; i++) {
			System.out.print("input : ");
			studentKorScore[i] = sc.nextDouble(); 
		}
		
		for(int i = 0; i < studentKorScore.length; i++) {
			System.out.println(studentKorScore[i]);
		}
		/*학생 3명의 국어 점수 평균을 구하고 출력하는 코드를
		 * 작성하세요.
		 */
		double sum = 0;
		double average = 0;
		for(int i = 0; i < studentKorScore.length; i++) {
			sum += studentKorScore[i];
		}
		average = sum / studentKorScore.length;
		System.out.println("Average score : " + average);
		
		sc.close();
	}

}
