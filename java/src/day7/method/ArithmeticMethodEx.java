package day7.method;

public class ArithmeticMethodEx {

	public static void main(String[] args) {
		
		int a = 1;
		int b = 2;
		
		System.out.println(sum(a, b));
		System.out.println(sub(a, b));
		System.out.println(mul(a, b));
		System.out.println(div(a, b));
		System.out.println(mod(a, b));
		sum2(a, b);
		

	}
	
	public static void sum2(int a, int b) {
		System.out.println(a + b);
	}
	
	public static int sum(int a, int b) {
		return a + b;
	}
	
	public static int sub(int a, int b) {
		return a - b;
	}
	
	public static int mul(int a, int b) {
		return a * b;
	}
	
	public static double div(double a, double b) {
		return a / b;
	}
	
	public static int mod(int a, int b) {
		return a % b;
	}

}
