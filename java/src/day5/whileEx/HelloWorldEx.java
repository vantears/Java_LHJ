package day5.whileEx;

public class HelloWorldEx {

	public static void main(String[] args) {
		int max = 3;
		int i = 1;
		while(i++ <= max) {
			System.out.println("Hello World!" + i);
		}
		System.out.println("======================");
		i = 3;
		max = 1;
		while(i-- >= max) {
			System.out.println("Hello World" + i);
		}
	}

}
