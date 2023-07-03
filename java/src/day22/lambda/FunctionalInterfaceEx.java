package day22.lambda;

import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

public class FunctionalInterfaceEx {

	public static void main(String[] args) {
		Consumer<String> consumer = s -> System.out.println(s);
		consumer.accept("Hong");
		Consumer<Student> consumer2 = s -> System.out.println(s.getName());
		Student std = new Student(1, 1, 1, "Hong");
		consumer2.accept(std);
		
		printStudent(std);
		printStudentName(std);
		
		printStudent(std, s->System.out.println(s));
		printStudent(std, s->System.out.println(s.getName()));
		
		printStudent(std, s->System.out.println(s.getGrade() + " " + s.getClassNum() + " " + s.getNum()));

	}
	//Print all info of the student
	public static void printStudent(Student std) {
		System.out.println(std);
	}
	//Print only name
	public static void printStudentName(Student std) {
		System.out.println(std.getName());
	}
	public static void printStudent(Student std, Consumer<Student> consumer) {
		consumer.accept(std);
	}
}

@Data
@AllArgsConstructor
class Student {
	int grade, classNum, num;
	String name;
}