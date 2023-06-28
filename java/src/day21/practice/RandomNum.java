package day21.practice;

import lombok.Data;

@Data
public class RandomNum {
	private String id;
	private int tryCount = 0;
	
	public RandomNum(String id, int tryCount) {
		this.id = id;
		this.tryCount = tryCount;
	}
	
}
