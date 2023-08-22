package db.day3.board.vo;

import lombok.Data;

@Data
public class BoardVO {
	private int bo_num;
	private String bo_title;
	private String bo_me_id;
	
	public BoardVO(String title, String id) {
		bo_title = title;
		bo_me_id = id;
	}

	public BoardVO(int num, String title, String me_id) {
		bo_num = num;
		bo_title = title;
		bo_me_id = me_id;
	}
	
	@Override
	public String toString() {
		return "[" + bo_num + "] : " + bo_title + " : [" + bo_me_id + "]"; 
	}

}
