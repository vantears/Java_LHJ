package day11.practice;
import java.util.Scanner;
public class ArrayRandomEx {

	public static void main(String[] args) {
		int index = 0, length, max;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array : ");
		length = sc.nextInt();
		int[] randomArray = new int[length];
		random ran = new random();
		max = ran.getMax();
		if(max < length) {
			ran.setMax(length);
		}
		createRandom(index, randomArray, length);
		System.out.println("==========");
		printArray(randomArray, length);
		
		int num;
		System.out.println("Enter a number : ");
		num = sc.nextInt();
		System.out.println("Is the number in the randomArray? : " + (contains(num, randomArray, length)? "Yes":"No"));
		
		int min, max2;
		System.out.println("Enter min, max number : ");
		min = sc.nextInt();
		max2 = sc.nextInt();
		createRandomArray(min, max2, randomArray);
		
		sc.close();
	}
	
	public static void createRandom(int index, int randomArray[], int length) {
		random ran = new random();
		for(int i = 0; i < length; i++) {
			do {
				index = ran.randomer();
			} while(Checker(randomArray, index));
			randomArray[i] = index;
			System.out.println(randomArray[i]);
		}
	}
	
	public static boolean Checker(int n[], int index) {
		for(int i = 0; i < n.length; i++) {
			if(n[i] == index) {
				return true;
			}
		}
		return false;
	}
	
	public static void printArray(int n[], int length) {
		int i;
		for(i = 0; i < length; i++) {
			System.out.println(n[i]);
		}
	}
	
	public static boolean contains(int num, int n[], int length) {
		for(int i = 0; i < length; i++) {
			if(num == n[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static void createRandomArray(int min, int max, int n[]) {
		if(max - min + 1 < n.length) {
			return;
		}
		random rd = new random();
		rd.setMin(min);
		rd.setMax(max);
		int index = 0;
		createRandom(index, n, n.length);
	}

}

class random {
	private int random;
	private int min = 1;
	private int max = 9;
	public int randomer() {
		random = (int)(Math.random() * (max - min + 1) + min);
		return random;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public void setMin(int min) {
		this.min = min;
	}	
}
