package day8.method;

public class MethodcallstackEx {

	public static void main(String[] args) {
		
		method1(1);

	}
	
	public static void method1(int a) {
		
		System.out.println(a);
		method2(a);
		
	}
	
	public static void method2(int a) {
		System.out.println(a - 1);
		method3();
	}
	
	public static void method3() {
		System.out.println("End");
	
}

}
