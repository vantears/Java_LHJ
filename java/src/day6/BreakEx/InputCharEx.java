package day6.BreakEx;
import java.util.Scanner;

public class InputCharEx {

	public static void main(String[] args) {
		
		char ch;
		Scanner sc = new Scanner(System.in);
		
		for( ; ; ) {
			System.out.println("Input character : ");
			ch = sc.next().charAt(0);
			if(ch == 'q') {
				break;
			}		
		}
		sc.close();
	}
}
