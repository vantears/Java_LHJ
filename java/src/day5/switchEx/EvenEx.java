package day5.switchEx;

public class EvenEx {

	public static void main(String[] args) {
		
		int a = 4;
		switch (a % 2) {
		case 0:
			System.out.println(a / 2);
			break;
		default:
			System.out.println(a + 1);
		
		}

	}

}
