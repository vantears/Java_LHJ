package kr.kh.app.vo;

import lombok.*;

@Data
@AllArgsConstructor
public class BoardVO {
	
	private int bo_num;
	private String bo_title;
	private String bo_me_id;
	
	// �Խñ� ����Ʈ���� ����� url�� �������ִ� �޼��� / board/detail?bo_num=1
	public String getBoardDetailUrl() {
		return "/board/detail?bo_num="+bo_num;
	}
	
}
