package day17.interfaceex;

public class RunInterface {
	public static void main(String[] args) {
		interFace face = new interFace();
		face.run();
		System.out.println(interfaceEx.num);
		interfaceEx.stop();
		face.change();
		face.delete();
	}
	
}

abstract class MotherClass {
	abstract void delete();
}

interface interfaceEx2 {
	default void change() {
		System.out.println("dont change!");
	}
}

interface interfaceEx {
	int num = 10;
	default void run() {
		System.out.println("Run!");
		print();
	}
	static void stop() {
		System.out.println("Stop");
	}
	
	private void print() {
		System.out.println("print");
	}

}

class interFace extends MotherClass implements interfaceEx, interfaceEx2 {
	public void change() {
		System.out.println("Change!");
	}

	@Override
	void delete() {
		System.out.println("Delete!");
		
	}

}