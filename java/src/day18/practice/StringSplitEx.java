package day18.practice;
import java.util.Scanner;

public class StringSplitEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		System.out.print("input : ");
		str = sc.nextLine();
		String words[] = str.split(" ");
		System.out.println("word :  " + words.length);
		sc.close();

	}

}
