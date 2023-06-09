package day18.practice;
import java.util.Scanner;

public class StringCharAtEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ex = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
		String str;
		System.out.print("Input : ");
		str = sc.nextLine();
		
		//for loop
		for(int i = 0; i < ex.length(); i+=2) {
			int exCount = 0;
			for(int j = 0; j < str.length(); j++) {
				if(ex.charAt(i) == str.charAt(j) || ex.charAt(i + 1) == str.charAt(j) ) {
					exCount++;
				}	
			}
			if(exCount > 0) {
				System.out.println(ex.charAt(i) + "(" + ex.charAt(i + 1) + ")" + " : " + exCount);				
			}
		}
		
		System.out.println("======================");
		
		//while loop
		int exIndex = 0;
		while(exIndex < ex.length()) {
			int exCount = 0;
			for(int j = 0; j < str.length(); j++) {
				if(ex.charAt(exIndex) == str.charAt(j) || ex.charAt(exIndex + 1) == str.charAt(j) ) {
					exCount++;
				}	
			}
			if(exCount > 0) {
				System.out.println(ex.charAt(exIndex) + "(" + ex.charAt(exIndex + 1) + ")" + " : " + exCount);
			}
			exIndex += 2;
		}
		sc.close();
	}
}
