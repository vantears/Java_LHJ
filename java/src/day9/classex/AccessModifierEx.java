package day9.classex;

import day9.classex2.B;


public class AccessModifierEx {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		a.num3 = 10;
		b.num3 = 20;
		
		//a.num1 = 10;
		//b.num1 = 20;
		
		a.num2 = 10;
		//b.num2 = 10;
		
		a.setNum1(2);
		a.print();
		
		System.out.println(a.getNum1());
	}
}

	class A {
		private int num1;
		int num2;
		public int num3;
		
		/**클래스 A의 객체 정보 중 num1을 출력하는 메서드
		 * 매개변수 : 없음 => 이미 알고 있는 내 정보 num1이기 때문에
		 * 리턴타입 : 없음 => void
		 * 메서드명 : print
		 * */
		public void print() {
			System.out.println(num1);
		}
		
		public int getNum1() {
			return num1;
		}
		
		public void setNum1(int _num1) {
			num1 = _num1;
		}
	}
