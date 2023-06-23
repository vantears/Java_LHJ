package day18.practice;

public class StringIndexOfEx {

	public static void main(String[] args) {
		String str = "Hello world";
		String search = "o";
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.indexOf(search, i) != -1){
				i = str.indexOf(search, i);
				count++;
			} else {
				break;
			}
		}
		System.out.println(count);

	}

}
