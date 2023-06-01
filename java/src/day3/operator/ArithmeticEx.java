package day3.operator;

public class ArithmeticEx {

	public static void main(String[] args) {
		byte num1 = 3;
		num1 = (byte)(num1 + 5);
		char ch = 'a';
		ch = (char)(ch + 1);
		System.out.println(num1);
		System.out.println(ch);
		int num2 = 3;
		num2 = (int)(3 + 4.0);
		System.out.println(num2);
	}
}
