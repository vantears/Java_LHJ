package day19.exception;

public class TryCatchEx {

	public static void main(String[] args) {
		try {
			System.out.println(1/0);
		} catch(ArithmeticException e) {
			System.out.println("Can't divide by zero");
		} catch(Exception e) {
			
		}
		System.out.println("Quitting");
	}

}
