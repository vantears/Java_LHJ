package day4.homework;
import java.util.Scanner;

public class TriangleEx {

	public static void main(String[] args) {
		/*세 변의 길이를 정수로 입력받아 세 변으로 삼각형을 만들 수 있는지 확인하는 코드를 작성하세요.
          (package : day4.homework, file : TriangleEx)
          세 변 중 작은 두 변의 길이의 합이 큰 변보다 커야 삼각형을 만들 수 있다.
          input 3 integer num : 
          1 2 3 
          Unable to create triangle.
          input 3 integer num : 
          2 2 3 
          Able to create triangle.
          */
		int line1;
		int line2;
		int line3;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 3 lines of triangle : ");
		line1 = sc.nextInt();
		line2 = sc.nextInt();
		line3 = sc.nextInt();
		if (line1 > line2 && line1 > line3) {
			if ((line2 + line3) > line1) {
				System.out.println("Able to create a triangle");
			} else {
				System.out.println("Unable to create a triangle");
			}
		} else if (line2 > line1 && line2 > line3) {
			if ((line1 + line3) > line2) {
				System.out.println("Able to create a triangle");
			} else {
				System.out.println("Unable to create a triangle");
			}
		} else if (line3 > line1 && line3 > line2) {
			if ((line1 + line2) > line3) {
				System.out.println("Able to create a triangle");
			} else {
				System.out.println("Unable to create a triangle");
			}
		} else {
			System.out.println("Unable to create a triangle");
		}
		sc.close();

	}

}
