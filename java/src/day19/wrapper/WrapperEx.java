package day19.wrapper;

//import java.util.ArrayList;

public class WrapperEx {

	public static void main(String[] args) {
		Integer num = 10;
		int num2 = 0; 
		if (num != null) {
			num2 = num;
		};
		System.out.println(num);
		System.err.println(num2);
		
		//ArrayList<Integer> list;
		
		int num3 = Integer.parseInt("123");
		System.out.println(num3);

	}

}