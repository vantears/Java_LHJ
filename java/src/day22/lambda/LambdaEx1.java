package day22.lambda;

public class LambdaEx1 {

	public static void main(String[] args) {
			
		InterfaceA b = num1 -> num1 * 10;
		
		System.out.println(b.getMax(10));
	}
}

interface InterfaceA {
	int getMax(int num1);
}

