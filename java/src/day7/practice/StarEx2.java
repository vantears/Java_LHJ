package day7.practice;

public class StarEx2 {

	public static void main(String[] args) {
		
		int i, j, x;
		for(i = 1; i <= 5; i++) {
			for(x = 5 - i; x >= 1; x--) {
				System.out.print(' ');
			}
			for(j = 1; j <= i + (i - 1); j++) {
				System.out.print('*');
				}
			System.out.println();
			}
		for(i = 4; i >= 1; i--) {
			for(x = 5 - i; x >= 1; x--) {
				System.out.print(' ');
			}
			for(j = 1; j <= i + (i - 1); j++) {
				System.out.print('*');
				}
			System.out.println();
			}
		
		}

	}
	
