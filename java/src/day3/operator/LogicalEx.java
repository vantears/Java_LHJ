package day3.operator;

public class LogicalEx {
 public static void main(String[] args) {
	 int score = 85;
	 // if score is 70 or greater and 80 or lower
	 System.out.println("Is " + score + " B grade? " +(score >= 80 && score <= 90));
	 int age = 21;
	 // adult is 20 or more
	 boolean isAdult = age >= 20;
	 // Is the age minor?
	 System.out.println("Is " + age + " minor? " + !isAdult );
	 
	 // I have a ID card but a Driver license
	 boolean hasIdCard = true;
	 boolean hasDriverlicense = false;
	 //Can I take TOEIC test? 
	 System.out.println("Can I take TOEIC? " + (hasIdCard || hasDriverlicense));
 }
}
