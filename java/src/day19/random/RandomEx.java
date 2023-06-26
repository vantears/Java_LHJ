package day19.random;
import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {
		int min = 5, max = 9;
		int r = (int)(Math.random() * (max - min + 1) + min);
		System.out.println(r);
		
		Random random = new Random();
		r = random.nextInt(max - min + 1) + min;
		System.out.println(r);
		
	}

}
