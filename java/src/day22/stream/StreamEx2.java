package day22.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamEx2 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
			new Student(1, 1, 1, "Hong", 100, 90, 80),
			new Student(1, 2, 2, "Park", 10, 30, 50),
			new Student(2, 1, 1, "Lee", 60, 30, 100),
			new Student(3, 1, 1, "Ling", 100, 90, 100),
			new Student(3, 2, 2, "Kim", 50, 90, 70)
	);
		Stream<Student> stream = list.stream();
		stream.filter(s -> s.getKor() >= 60).map(s -> s.getName()).forEach(name -> System.out.println(name));
		
		stream = list.stream();
		stream.filter(s -> s.getKor() >=60).forEach(std -> System.out.println(std.getName()));
		
		stream = list.stream();
		int sum = stream.mapToInt(std -> std.getKor()).sum();
		System.out.println(sum);
		
		stream = list.stream();
		double average = stream.mapToInt(std -> std.getKor()).average().getAsDouble();
		System.out.println(average);
		
		stream = list.stream();
		sum = stream.map(std -> std.getKor()).reduce(0, (a, b) -> a + b);
		System.out.println(sum);
	}
	
}

@Data
@AllArgsConstructor
class Student {
	int grade, classNum, num;
	String name;
	int kor, math, eng;
}
