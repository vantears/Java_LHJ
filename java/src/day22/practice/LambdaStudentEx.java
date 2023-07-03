package day22.practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class LambdaStudentEx {
	
	static List<Student> list = Arrays.asList(
			new Student(1, 1, 1, "Hong"),
			new Student(1, 1, 2, "Ling"),
			new Student(2, 1, 1, "Park"),
			new Student(3, 1, 1, "Lee"),
			new Student(3, 3, 2, "Kim")
			);

	public static void main(String[] args) {
		/* Build a program that prints student's information
		 * 1. Print all info
		 * 2. Print only grade
		 * 3. Search a student
		 * 4. Quit
		 */
		
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Menu");
			System.out.println("1. Print all info");
			System.out.println("2. Print only grade");
			System.out.println("3. Search a student");
			System.out.println("4. Quit");
			System.out.print("Choose an option : ");
			menu = sc.nextInt();
			Stream<Student> Stream = list.stream();
			switch(menu) {
			case 1:
				Stream.forEach(std -> System.out.println(std));
				break;
			case 2:
				System.out.println("Enter the student's grade to search : ");
				int grade = sc.nextInt();
				Stream.filter(std -> std.getGrade() == grade).forEach(std -> System.out.println(std));
				break;
			case 3:
				System.out.println("Grade : ");
				int grade2 = sc.nextInt();
				System.out.println("Class : ");
				int classNum = sc.nextInt();
				System.out.println("Num : ");
				int num = sc.nextInt();
				Stream.filter(std -> std.equals(new Student(grade2, classNum, num, null))).forEach(std -> System.out.println(std));
				break;
			case 4:
				System.out.println("Quitting!");
				break;
			default:
				System.out.println("Wrong option!");
			}
		} while(menu != 4);
		sc.close();
	}
	
	public static void printStudent (Predicate<Student> p){
		for(Student tmp : list) {
			if(p.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}

}

@Data
@AllArgsConstructor
class Student {
	int grade, classNum, num;
	String name;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}
	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}
}