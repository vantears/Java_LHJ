package day19.exception;

public class NullPointerExceptionEx {

	public static void main(String[] args) {
		String str = "aaa";
		//System.out.println(str.substring(0));
		test(str);

	}
	
	public static void test(String str) {
		if(str == null) {
			return;
		} else {
			System.out.println(str.substring(0));
		}
	}

}
