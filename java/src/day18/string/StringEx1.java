package day18.string;

public class StringEx1 {

	public static void main(String[] args) {
		String str = "Hello World";
		
		int index = str.indexOf("Wo", 7);
		System.out.println(index);
		
		index = str.indexOf("o");
		System.out.println(index);
		
		boolean result = str.contains("o");
		System.out.println(result);
		
		System.out.println(str.length());
		
		String str2 = str.replace("Hello", "Bye");
		System.out.println(str2);
		
		System.out.println(str.substring(6));
		
		System.out.println(str.lastIndexOf("o"));
		
		System.out.println(str.toUpperCase());
		
		System.out.println(str.toLowerCase());
		
		String str3 = "\n\t\tabc\t\tdef\t\n";
		System.out.println(str3);
		System.out.println(str3.trim());
		
		String str4 = "Apple,Pear,Grapes";
		String fruits[] = str4.split(",");
		for(String fruit : fruits) {
			System.out.println(fruit);
		}

	}

}
