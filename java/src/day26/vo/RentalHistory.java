package day26.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RentalHistory implements Serializable{
	
	private static final long serialVersionUID = -440458267576590338L;
	
	Books book;
	String rentalDate;
	String dueDate;
	String returnDate;
	
	public RentalHistory(Books book, String rentalDate, String dueDate) {
		this.book = book;
		this.rentalDate = rentalDate;
		this.dueDate = dueDate;
	}
	
	public void print() {
		System.out.println("-------------");
		System.out.println("Book : " + book.getTitle());
		System.out.println("Rental Date : " + rentalDate);
		System.out.println("Due Date : " + dueDate);
		if(returnDate == null) {
			System.out.println("Return Date : not returned yet");
		} else {
			System.out.println("Return Date : " + returnDate);			
		}
	}
}
