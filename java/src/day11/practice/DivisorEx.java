package day11.practice;
import java.util.Scanner;

public class DivisorEx {

	public static void main(String[] args) {
		int num;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		num = sc.nextInt();
		int count = 0;
		int[] array = new int[num];
		for(int i = 1; i <= array.length; i++) {
			if (num % i == 0) {
				array[count] = i;
				count++;
			}
		}
		int[] array2 = new int[count];
		System.arraycopy(array, 0, array2, 0, count);
		for(int tmp : array2) {
			System.out.println(tmp);
		}
		sc.close();

	}

}
