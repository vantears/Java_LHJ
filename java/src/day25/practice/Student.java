package day25.practice;

import java.io.Serializable;

import lombok.Data;

@Data
public class Student implements Serializable {

	private static final long serialVersionUID = -1740341550133479720L;
	
	private String num, major, name;
	
	private static int MAX_SIZE = 2;
	
	
	
	public Student(String major, String name, int listCount) {
		this.major = major;
		this.name = name;
		creatNum(listCount);
	}
	
	private void creatNum(int listCount) {
		String num = "" + ++listCount;
		for(int i = 0; i < MAX_SIZE - num.length(); i++) {
			num = "0" + num;
		}
		this.num = "2023" + num;
	}
	
	public void print() {
		System.out.println("----------");
		System.out.println("Student ID : " + num);
		System.out.println("Major : " + major);
		System.out.println("Name : " + name);
	}
	
	
}
