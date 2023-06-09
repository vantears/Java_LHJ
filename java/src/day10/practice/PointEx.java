package day10.practice;

public class PointEx {

	public static void main(String[] args) {
		point pt1 = new point();
		pt1.print();
		pt1.move(10, 20);
		pt1.print();
		
		point pt2 = new point(30, 40);
		pt2.print();

	}

}

class point {
	private int x, y;
	
	//Constructor
	public point() {}
	
	//Constructor overloading
	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//getter, setter
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void print() {
		System.out.println("" + x + ", " + y + "px");
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}