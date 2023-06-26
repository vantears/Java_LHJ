package day19.mathex;

public class MathEx {

	public static void main(String[] args) {
		System.out.println(Math.abs(-1.2));
		System.out.println(Math.ceil(1.29));
		System.out.println(Math.floor(1.29));
		System.out.println(Math.round(1.29));
		System.out.println(Math.random());
		System.out.println(Math.pow(2, 3));
		//1.29의 소수점 둘째자리에서 반올림
		double num = 1.29;
		int pos = 2;
		num *= Math.pow(10, pos - 1);
		num = Math.round(num);
		num /= Math.pow(10, pos - 1);
		System.out.println(num);

	}

}
