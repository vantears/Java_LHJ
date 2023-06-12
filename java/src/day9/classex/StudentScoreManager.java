package day9.classex;
import java.util.Scanner;

public class StudentScoreManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
		
		Score1 korScore = new Score1();
		Score1 engScore = new Score1(2, 2, "math");
		System.out.println(korScore.grade);
		System.out.println(engScore.grade);

	}

}

class Score1 {
	String title;
	int grade;
	int semester;
	double total;
	double midTerm;
	double finalExam;
	double performance;
	public Score1() {
		/* title의 기본값은? null
		 * grade의 기본값은? 0
		 * total의 기본값은? 0.0
		 */
		title = "";
		grade = 1;
		semester = 1;
		
	}
	
	public Score1(int _grade, int _semester, String _title) {
		grade = _grade;
		semester = _semester;
		title = _title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getMidTerm() {
		return midTerm;
	}

	public void setMidTerm(double midTerm) {
		this.midTerm = midTerm;
	}

	public double getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}

	public double getPerformance() {
		return performance;
	}

	public void setPerformance(double performance) {
		this.performance = performance;
	}

	public Score1(String title, int grade, int semester, double total, double midTerm, double finalExam,
			double performance) {
		this.title = title;
		this.grade = grade;
		this.semester = semester;
		this.total = total;
		this.midTerm = midTerm;
		this.finalExam = finalExam;
		this.performance = performance;
	}
	
}

class Strudent1 {
	String name;
	String residentNumber;
	int greade;
	int classNum;
	int number;
	int admissionYear;
	Score1 korScore, engScore, mathScore;
}