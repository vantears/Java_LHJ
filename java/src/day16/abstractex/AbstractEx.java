package day16.abstractex;

public class AbstractEx {

	public static void main(String[] args) {
		ChildA2 ch = new ChildA2();
		ChildA2 ch2 = new ChildA2();
		ch.test();
		
		A a = new A() {
			public void test() {
				System.out.println("Test");
			}
		};
		a.test();
		
		A a2 = new ChildA2();
		a.test();
		a2.test();
		ch2.test2();
		a = (ChildA2)a2;
		a.test();
		ch2.test2();
		
	}

}

abstract class A {
	public int num;
	public abstract void test();
	public final void test2() {
		System.out.println("Test2");
	}
}


class ChildA2 extends A {

	public void test() {
		num = 5;
		System.out.println(num);
	}

}