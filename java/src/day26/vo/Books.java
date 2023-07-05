package day26.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Books implements Serializable {
	
	private static final long serialVersionUID = -7616010455679344815L;
	
	private String title, author, num;
	private int isbn;
	private int max_size = 6;
	private boolean isRent = false;
	
	public Books(String title, String author, int bookCount) {
		this.title = title;
		this.author = author;
		createNum(bookCount);
	}

	private void createNum(int bookCount) {
		String firstLetter = "" + title.charAt(0);
		String num = "" + bookCount;
		for(int i = 0; i < max_size - num.length(); i++) {
			num = "0" + num;
		}
		this.num = firstLetter.toUpperCase() + num;
		
	}

	@Override
	public String toString() {
		return "-----------" + "\n" + "Book no. " + num + "\n" + "Title : " + title + "\n" + "Author : " + author + "\n" + "ISBN : " + isbn + "\n" + "-----------";
	}
	
}
