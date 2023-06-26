package day19.exception;

public class ExceptionEx1 {

	public static void main(String[] args) {
		int num1 = 1, num2 = 0;
		System.out.println(num1/num2);

	}

}

class A implements Cloneable {
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
