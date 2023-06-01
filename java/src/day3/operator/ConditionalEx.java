package day3.operator;

public class ConditionalEx {

	public static void main(String[] args) {
		// if the age is 20 or more then adult, if not then minor
		int age = 30;
		String str;
		
		str = age >= 20 ? "adult" : "minor";
		System.out.println(age + " years old is a(an) " + str);
	}
}
