package day10.thisex;

public class StudentMain {

	public static void main(String[] args) {
		Student1.printCount();
		
		Student1 std1 = new Student1(1,1,1,"hong");
		Student1.printCount();
		
		Student1 std2 = new Student1(1,1,2,"lim");
		Student1.printCount();
		
		//std2.studentCount = 1;
		//Student1.printCount();
		std1.print();
		std2.print();

	}

}
class Student1 {
	static int studentCount;
	private int grade, classNum, number;
	private String name;
	
	public Student1(int grade, int classNum, int number, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.number = number;
		this.name = name;
		studentCount += 1;
	}
	public Student1() {
		this(1, 1, 1, "");
		/*
		grade = 1;
		classNum = 1;
		number = 1;
		name = "";
		*/
	}
	
	public void print() {
		System.out.println("===============");
		System.out.println("grade     : " + grade);
		System.out.println("classNum  : " + classNum);
		System.out.println("number    : " + number);
		System.out.println("name      : " + name);
		//System.out.println("count     : " + studentCount);
		//printCount();
	}
	public static void printCount() {
		System.out.println("Registered student count : " + studentCount);
		//스태틱은 객체 생성 전에 객체 변수 또는 객체 메소드 사용 불가
		//print();
		//grade = 1;
		
		//객체를 생성 후 호출해야 사용 가능
		//Student1 std1 = new Student1();
		//std1.name = "hong";
		//std1.print();
	}
}
