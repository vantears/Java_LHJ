package kr.kh.app.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {
	
	private int page;
	
	private int perPageNum;
	
	//�� �������� ���� 5���� �ְ�, ���� �������� 3�������̸�
	//limit�� �̿��� �� limit 10, 5�� �Է��ؾ� �ϴµ�,
	// limit�ؼ� ���� ������ ����ϴ� getter
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
}
