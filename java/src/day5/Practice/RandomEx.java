package day5.Practice;

public class RandomEx {

	public static void main(String[] args) {
		
		int min, max;
		int random;
		min = 1;
		max = 50;
		random = (int)(Math.random() * (max - min + 1) + min);
		System.out.println(random);

	}

}
