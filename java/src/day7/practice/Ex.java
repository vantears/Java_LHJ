package day7.practice;

public class Ex {

	public static void main(String[] args) {
		
		char ch, end;
		for(end = 'A'; end <= 'Z'; end++) {
			for(ch = 'A'; ch <= end; ch++) {
				System.out.print(ch);
			}
			System.out.println();
		}

	}

}
