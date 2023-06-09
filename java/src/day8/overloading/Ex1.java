package day8.overloading;

public class Ex1 {

	public static void main(String[] args) {
		
		System.out.println(1);
		System.out.println("C");
		System.out.println(1.1);
		System.out.println('C');
		System.out.println(sum(1, 2));
		System.out.println(sum(1.4, 1));
		System.out.println(sum(1, 1.2));
		System.out.println(sum(1.4, 1.2));
		System.out.println(sum(1, 2, 3));

	}
	
	public static int sum(int a, int b) {
		return a + b;
	}
	
	public static double sum(double a, int b) {
		return a + b;
	}
	
	public static double sum(int a, double b) {
		return a + b;
	}
	
	public static double sum(double a, double b) {
		return ((a * 10) + (b * 10)) / 10;
	}
	
	public static int sum(int a, int b, int c) {
		return a + b + c;
	}
}
