package day3.operator;

public class Ex3 {
	
 public static void main(String[] args) {
	 //comparison of two numbers
	 System.out.println("1 > 2 : " + (1 > 2));
	 System.out.println("1 < 2 : " + (1 < 2));
	 System.out.println("1 == 2 : " + (1 == 2));
	 System.out.println("1 >= 2 : " + (1 >= 2));
	 System.out.println("1 <= 2 : " + (1 <= 2));
	 System.out.println("1 != 2 : " + (1 != 2));
	 
	 /* str1 and str2 store literal 'abc' so we can use '==' to compare them,
	    but str3 stores the address of new string containing 'abc' so we cannot use '==' to compare
	    because '==' compares the address of the variables being compared. 
	    If we use 'equals' function then we can just compare the actual values of two variables*/
	 String str1 = "abc";
	 String str2 = "abc";
	 String str3 = new String("abc");
	 String str4 = "ab";
	 String str5 = "c";
	 String str6 = str4 + str5;
	 System.out.println("str1 == str2 : " + (str1 == str2));
	 System.out.println("str1 == str3 : " + (str1 == str3));
	 System.out.println("str2 == str3 : " + (str2 == str3));
	 System.out.println("str1 == str6 : " + (str1 == str6));
	 System.out.println("str1 == str2 : " + (str1.equals(str2)));
	 System.out.println("str1 == str3 : " + (str1.equals(str3)));
	 System.out.println("str2 == str3 : " + (str2.equals(str3)));
	 System.out.println("str1 == str6 : " + (str1.equals(str6)));
	 
	 if (str1.equals(str2) && str1.equals(str2)) {
		 System.out.println("true");
	 } else {
		 System.out.println("false");
	 }
 }
}
