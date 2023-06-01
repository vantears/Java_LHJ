package day3.operator;

public class SCEEx {

	public static void main(String[] args) {
		String str = null;
		// Short circuit evaluation skips the second comparison if the first one already determines if the value is true or false
		System.out.println("Is " + str + " equal to abc? " + (str != null && str.equals("abc")));
		//System.out.println("Is " + str + " equal to abc? " + (str.equals("abc") && str != null));
		System.out.println("Is " + str + " equal to abc? " + ((str != null) ? true : false));
	}
}
