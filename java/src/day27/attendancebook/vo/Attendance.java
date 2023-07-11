package day27.attendancebook.vo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Attendance {
	String date;
	ArrayList<Student> students = new ArrayList<>();
	
	public Attendance(String date, ArrayList<Student> students) {
		this.date = date;
		for(Student tmp : students) {
			this.students.add(new Student(tmp));
		}
	}
	
	public Attendance(String date, ArrayList<Student> students, Student student) {
		this.date = date;
		for(Student tmp : students) {
			this.students.add(new Student(tmp));
			attendStudent(student);
		}
	}
	
	public Attendance(String date, Student student) {
		this.date = date;
		students.add(new Student(student));
	}
	
	public void print() {
		System.out.println("Date : " + date);
		for(Student tmp : students) {
			tmp.print();
		}
	}
	
	public void attendStudent(Student student) {
		for(Student tmp : students) {
			if(tmp.getName().equals(student.getName())) {
				tmp.setAttendance(true);
			}
		}
	}
	
	public void addStudent(Student student) {
		students.add(new Student(student));
	}
	
}
