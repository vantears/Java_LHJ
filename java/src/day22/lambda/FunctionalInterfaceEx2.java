package day22.lambda;

import java.util.function.*;

public class FunctionalInterfaceEx2 {

	public static void main(String[] args) {
		Supplier<String> supplier = () -> "Hi";
		System.out.println(supplier.get());
		
		Function<Student, String> function = std -> std.getName();
		System.out.println(function.apply(new Student(1, 1, 1, "Hong")));
		
		UnaryOperator<Student> operator = std -> { 
			std.setGrade(2); 
			return std;
		};
		System.out.println(operator.apply(new Student(1, 1, 1, "Hong")));
		
		Predicate<Student> predicate = s -> s.getName().indexOf("Hong") == 0;
		System.out.println(predicate.test(new Student(1, 1, 1, "Hong")));
	}

}
