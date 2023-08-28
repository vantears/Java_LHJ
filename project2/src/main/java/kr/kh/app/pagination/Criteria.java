package kr.kh.app.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {
	
	private int page;
	
	private int perPageNum;
	
	//한 페이지에 글이 5개가 있고, 현재 페이지가 3페이지이면
	//limit을 이용할 때 limit 10, 5를 입력해야 하는데,
	// limit해서 시작 번지를 계산하는 getter
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
}
