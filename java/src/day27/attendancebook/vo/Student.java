package day27.attendancebook.vo;

import lombok.Data;

@Data
public class Student {
	private String name;
	private boolean attendance;
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(Student student) {
		name = student.getName();
		attendance = student.isAttendance();
	}
	
	public Student(Student student, boolean attendance2) {
		name = student.getName();
		attendance = attendance2;
	}

	public void print() {
		System.out.println(name + " : " + (attendance? "O":"X"));
	}
}
