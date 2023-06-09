package day10.practice;

public class RectEx {

	public static void main(String[] args) {
		Rect1 rect1 = new Rect1(0, 0, 10, 10);
		rect1.print();
		rect1.move(10, 10);
		rect1.print();
		rect1.resize(10, 10, 20, 20);
		rect1.print();
		rect1.resize(0, 0, 20, 20);
		rect1.print();
		
		System.out.println("Rect2 start!");
		
		Rect2 rect2 = new Rect2(new point(0,0), new point(10,10));
		rect2.print();
		rect2.move(10, 10);
		rect2.print();
		rect2.resize(10, 10, 20, 20);
		rect2.print();
		rect2.resize(0, 0, 30, 30);
		rect2.print();
		
		Rect2 rect3 = new Rect2(0, 0, 10, 10);
		rect3.print();
		
		point pt1 = new point(0,0);
		point pt2 = new point(10,10);
		
		Rect2 rect4 = new Rect2(pt1, pt2);
		rect4.print();
	}

}

class Rect1 {
	private int leftUpX, leftUpY, rightDownX, rightDownY;

	public Rect1(int leftUpX, int leftUpY, int rightDownX, int rightDownY) {
		this.leftUpX = leftUpX;
		this.leftUpY = leftUpY;
		this.rightDownX = rightDownX;
		this.rightDownY = rightDownY;
	}

	public int getLeftUpX() {
		return leftUpX;
	}

	public void setLeftUpX(int leftUpX) {
		this.leftUpX = leftUpX;
	}

	public int getLeftUpY() {
		return leftUpY;
	}

	public void setLeftUpY(int leftUpY) {
		this.leftUpY = leftUpY;
	}

	public int getRightDownX() {
		return rightDownX;
	}

	public void setRightDownX(int rightDownX) {
		this.rightDownX = rightDownX;
	}

	public int getRightDownY() {
		return rightDownY;
	}

	public void setRightDownY(int rightDownY) {
		this.rightDownY = rightDownY;
	}
	
	public void print() {
		System.out.println("================");
		System.out.println("LU point : " + leftUpX + ", " + leftUpY);
		System.out.println("RD point : " + rightDownX + ", " + rightDownY);
	}
	
	public void move(int x, int y) {
		int dx = leftUpX - x;
		int dy = leftUpY - y;
		leftUpX = x;
		leftUpY = y;
		rightDownX = rightDownX - dx;
		rightDownY = rightDownY - dy;
	}
	
	public void resize(int x, int y, int w, int h) {
		leftUpX = x;
		leftUpY = y;
		rightDownX = x + w;
		rightDownY = x + h;
	}
	
}

class Rect2{
	private point leftUp, rightDown;

	public Rect2(point leftUp, point rightDown) {
		this.leftUp = leftUp;
		this.rightDown = rightDown;
	}
	
	public Rect2(int leftUpX, int leftUpY, int rightDownX, int rightDownY) {
		leftUp = new point(leftUpX, leftUpY);
		rightDown = new point(rightDownX, rightDownY);
	}
	
	public void print() {
		System.out.println("================");
		System.out.print("LU point : " );
		leftUp.print();
		System.out.print("RD point : " );
		rightDown.print();
	}
	
	public void move(int x, int y) {
		int dx = leftUp.getX() - x;
		int dy = leftUp.getY() - y;
		leftUp.move(x, y);
		rightDown.move(rightDown.getX() - dx, rightDown.getY() - dy);
	}
	
	public void resize(int x, int y, int w, int h) {
		leftUp.move(x, y);
		rightDown.move(x + w, y + h);
	}
	
}
