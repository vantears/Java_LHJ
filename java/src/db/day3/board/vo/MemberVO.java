package db.day3.board.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String me_id;
	private String me_pw;
	private int me_board_count;
	
	//생성자
	public MemberVO(String id, String pw) {
		me_id = id;
		me_pw = pw;
	}
	
	//다른 setter와 getter : 날짜 관련해서
	
}
