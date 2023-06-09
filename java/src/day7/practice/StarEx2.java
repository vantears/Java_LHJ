package day7.practice;

public class StarEx2 {

	public static void main(String[] args) {
		
		int i, j, x;
		int line = 21;
		for(i = 1; i <= line; i++) {
			int half = (line + 1) / 2;
			if(i <= half) {
				for(x = 1; x <= half - i; x++) {
					System.out.print(' ');
				}
				for(j = 1; j <= i + i - 1; j++) {
					System.out.print('*');
					}
				System.out.println();
				}
			else {
				for(x = 1; x <= i - half; x++) {
					System.out.print(' ');
					}
				for(j = 1; j <= 2 * (line - i) + 1; j++) {
					System.out.print('*');
					}
				System.out.println();
				}
			}
		}
	}
	
