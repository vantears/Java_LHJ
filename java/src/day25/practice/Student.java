package day25.practice;

import lombok.Data;

@Data
public class Student {
	private String num;
	private String major;
	private String name;
	
	private static int count = 0;
	private static int MAX_SIZE = 2;
	
	
	
	public Student(String major, String name) {
		this.major = major;
		this.name = name;
		creatNum();
	}
	
	private void creatNum() {
		String num = "" + ++count;
		for(int i = 0; i < MAX_SIZE - num.length(); i++) {
			num = "0" + num;
		}
		this.num = "2023" + num;
	}
	
	
}
