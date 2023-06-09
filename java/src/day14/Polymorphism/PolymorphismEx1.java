package day14.Polymorphism;

public class PolymorphismEx1 {

	public static void main(String[] args) {
		/* 매개변수의 다형성
		 * 리모컨으로 여러 제품의 전원을 켜는 예제
		 * 제품 : TV, 에어컨, 라디오
		 * 리모컨 클래스, TV 클래스, 에어컨 클래스, 라디오 클래스
		 * */
		
		tv tv1 = new tv();
		radio radio1 = new radio();
		airConditioner aircon1 = new airConditioner();
		remoteController remocon = new remoteController();
		remocon.turnOn(tv1);//TV를 켜는 기능
		remocon.turnOn(aircon1);//에어컨을 켜는 기능
		remocon.turnOn(radio1);// 라디오를 켜는 기능
		remocon.turnOff(aircon1);
		System.out.println("=====================");
		//매개변수의 다형성 이용
		tv1 tv2 = new tv1();
		radio1 radio2 = new radio1();
		airConditioner1 aircon2 = new airConditioner1();
		remoteController1 remocon2 = new remoteController1();
		
		homeAppliances appliance = tv2;//업캐스팅
		remocon2.turnOff(appliance);
		remocon2.turnOn(tv2);//가전을 켜는 기능
		remocon2.turnOn(aircon2);//가전을 켜는 기능
		remocon2.turnOn(radio2);//가전을 켜는 기능
		remocon2.turnOff(tv2);
		remocon2.turnOff(aircon2);
		remocon2.turnOff(radio2);
		System.out.println(tv2.power? "On":"Off");

	}

}

class remoteController {
	public void turnOn(tv tv) {
		tv.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOn(airConditioner aircon) {
		aircon.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOn(radio radio) {
		radio.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOff(tv tv) {
		tv.turnOff();
		System.out.println("전원이 꺼졌습니다.");
	}
	public void turnOff(airConditioner aircon) {
		aircon.turnOff();
		System.out.println("전원이 꺼졌습니다.");
	}
	public void turnOff(radio radio) {
		radio.turnOff();
		System.out.println("전원이 꺼졌습니다.");
	}
}

class tv {
	boolean power;
	int channel;
	void turnOn() {
		power = true;
	}
	void turnOff() {
		power = false;
	}
	
}

class airConditioner {
	boolean power;
	double currentTemperature;
	double desiredTemperature;
	void turnOn() {
		power = true;
	}
	void turnOff() {
		power = false;
	}
}

class radio {
	boolean power;
	double frequency;
	void turnOn() {
		power = true;
	}
	void turnOff() {
		power = false;
	}
}

class remoteController1 {
	public void turnOn(homeAppliances appliance) {
		appliance.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOff(homeAppliances appliance) {
		appliance.turnOff();
		System.out.println("전원이 꺼졌습니다.");
	}
}

class tv1 extends homeAppliances {
	int channel;	
}

class airConditioner1 extends homeAppliances {
	double currentTemperature;
	double desiredTemperature;
}

class radio1 extends homeAppliances {
	double frequency;
}

class homeAppliances {
	boolean power;
	void turnOn() {
		power = true;
	}
	void turnOff() {
		power = false;
	}
}
