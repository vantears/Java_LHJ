package day14.switchEx;

public class SwitchEx {

	public static void main(String[] args) {
		// switch문에서 case에 변수를  선언하면 다른 case에서 선언 할 수 없다는 걸 보여주는 예제
		// The example that shows you can't declare the variable that is already declared in the other case clause
		// case 문에 break가 선택이지 필수가 아님
		// 'break' is just optional in case clauses
		
		int menu = 1;
		
		switch(menu) {
		case 1:
			String title = "제목1";
			System.out.println(title);
			break;
		case 2:
			String title2 = "제목2";
			System.out.println(title2);
			break;
		case 3:
			
			break;
		}
	}

}
