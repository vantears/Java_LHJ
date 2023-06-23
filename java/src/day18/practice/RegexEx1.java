package day18.practice;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexEx1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("input : ");
		String str = sc.nextLine();
		String isImage = 
				Pattern.matches("[a-zA-Z]+.jpg$|[a-zA-Z]+.png$|[a-zA-Z]+.bmp$", str)?
						"Image":"Not image";
		System.out.println(str + " : " + isImage);
		
		sc.close();

	}

}
