package day7.method;

public class sumMethodEx {
	
	/**
	 * Function : add two integers
	 * @param a integer1
	 * @param b integer2
	 * @return the addition of the two integers
	 */
	public static int sum(int a, int b) {
		int res = a + b;
		return res;
	}

	public static void main(String[] args) {
		
		int res = sum(1, 2);
		System.out.println(res);

	}

}
