package day15.polymorphism;
import java.util.ArrayList;

public class InstancePolymorphismEx {

	public static void main(String[] args) {
		/* TV 1대, 에어컨 2대, 라디오 3개를 객체를 생성한 후
		 * 전원을 켜는 기능을 실행해보세요 */
		remoteController remote = new remoteController();
		
		/*tv tv = new tv();
		airConditioner airs[] = new airConditioner[2];
		radio radios[] = new radio[3];
		
		for(int i = 0; i < airs.length; i++) {
			airs[i] = new airConditioner();
		}
		
		for(int i = 0; i < radios.length; i++) {
			radios[i] = new radio();
		}
		
		
		remote.turnOn(tv); //매개변수의 다형성
		for(airConditioner air : airs) {
			remote.turnOn(air);//매개변수의 다형성
		}
		for(radio radio : radios) {
			remote.turnOn(radio);
		}*/
		
		//포함 다형성 예제, 객체 다형성 예제
		tv tv1 = new tv();
		int tvCount =1, airCount = 2, radioCount = 3;
		int total = tvCount + airCount + radioCount;
		homeAppliances home[] = new homeAppliances[total];
		int count = 0; // 현재 만들어진 제품 갯수
		for(int i = 0; i < tvCount; i++) {
			home[count++] = new tv();//업캐스팅
		}
		for(int i = 0; i < airCount; i++) {
			home[count++] = new airConditioner();//업캐스팅
		}
		for(int i = 0; i < radioCount; i++) {
			home[count++] = new radio();//업캐스팅
		}
		
		for(homeAppliances hom : home) {
			remote.turnOn(hom);
		}
		System.out.println("=============");
		for(homeAppliances hom : home) {
			//라이도로 다운캐스팅이 가능한 객체만 끔 => 라디오만 끔
			if(hom instanceof radio) {
				remote.turnOff(hom);
			}
		}
		System.out.println("=============");
		radio radio[] = new radio[10];
		for(int i = 0; i < radio.length; i++) {
			radio[i] = new radio();
		}
		ArrayList<homeAppliances>home2 = new ArrayList<>();
		for(int i = 0; i < radio.length; i++) {
			home2.add(radio[i]);
			remote.turnOn(home2.get(i));
		}
	}

}

class remoteController {
	public void turnOn(homeAppliances appliance) {
		appliance.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOff(homeAppliances appliance) {
		appliance.turnOff();
		System.out.println("전원이 꺼졌습니다.");
	}
}

class tv extends homeAppliances {
	int channel;	
}

class airConditioner extends homeAppliances {
	double currentTemperature;
	double desiredTemperature;
}

class radio extends homeAppliances {
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
