package day14.member.variable;

public class Ex {

	public static void main(String[] args) {
		/* An example of initializing parameters
		 * parameter initializing order
		 *  1. default : int num's default value is initialized as 0
		 *  2. explicit initialization : declare int num and initialize it as 1
		 *  3. initialized block : initialize int num as 2 in the initialized block {}
		 */

		System.out.println(TestA.num2);
		TestA a = new TestA();
		System.out.println(a.num);
		System.out.println(TestA.num2);

	}

}

class TestA{
	int num = 1;
	{
		num = 2;
	}
	public TestA() {
		num = 3;
		num2 = 3;
	}
	
	static int num2 = 1;
	//static initialized block
	static {
		num2 = 2;
	}
}
