package day6.nestedloop;

public class MultiplicationTableEx {

	public static void main(String[] args) {
		int x, y = 0;
		for(x = 2; x <= 9; x++) {
			for(y = 1; y <= 9; y++) {
				System.out.println(x + " x " + y + " = " + (x * y));
			}
		}
		
	}

}
