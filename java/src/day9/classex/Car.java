package day9.classex;

public class Car {
	//멤버 변수(필드)
	private String name; //차명
	private String company; //제조사
	private int year; //연식
	private int speed; //속력
	private char gear; //P:주차, R:후진, D:주행, N:중립
	private boolean power; //전원
	
	//생성자
	public Car(String _name, String _company, int _year) {
		name = _name;
		company = _company;
		year = _year;
		gear = 'P';
	}
	
	//메서드
	/**자동차 정보를 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : void
	 * 메서드명 : printInfo
	 * */
	public void printInfo() {
		System.out.println("*CAR INFORMATION*");
		System.out.println("MODEL : " + name);
		System.out.println("COMPANY : " + company);
		System.out.println("YEAR : " + year);
		System.out.println("SPEED : " + speed);
		System.out.println("GEAR : " + gear);
		System.out.println("POWER : " + (power?"On":"Off"));
		System.out.println();
	}
	
	public void speedChange(boolean positive) {
		if(!power) {
			return;
		}
		if(gear == 'N' || gear == 'P') {
			return;
		}
		if(positive) {
			speed += 1;
		} else if(speed > 0) {
			speed -= 1;
		}
	}
	
	public void turn() {
		if(!power) {
			power = true;
		} else if(gear == 'P'){
			power = false;
		}
	}

	public void setGear(char _gear) {
		if(_gear == 'P' || _gear == 'R' || _gear == 'D' || _gear == 'N') {
			gear = _gear;
		}
	}

}
