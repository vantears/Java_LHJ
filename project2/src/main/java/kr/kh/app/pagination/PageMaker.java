package kr.kh.app.pagination;

import lombok.Data;

@Data
public class PageMaker {

	private int startPage; // ���������̼ǿ��� ���� ������ ��ȣ
	private int endPage; // ���������̼ǿ��� ������ ������ ��ȣ
	private boolean prev; // ���� ��ư Ȱ��ȭ
	private boolean next; // ���� ��ư Ȱ��ȭ
	private int displayPageNum; // �����ִ� ������ �ִ� ����
	private Criteria cri; // ���� ������ ����
	private int totalCount; // �Խñ� ��ü�� => endPage ����� ���� �ʿ�
	
	
	public void calculate() {
		//�־����� ���� : ���� ������ ����, ��ä �Խñ� ��, �� ���������̼ǿ��� �����ִ� ������ �ִ� ����
		//���÷� ���� �������� 1��������, ���������� �Խñ��� 5��, ��ü �Խñ� 15, 5��

		//���� �������� �̿��Ͽ� �ִ� ������ ������ �������� ��� => 5
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		
		startPage = endPage - displayPageNum + 1;
		
		int lastEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));
		
		if(endPage > lastEndPage) {
			endPage = lastEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage == lastEndPage ? false : true;
	}
	
	public PageMaker(int totalCount, int displayPageNum, Criteria cri) {
		this.totalCount = totalCount;
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		calculate();
	}
	
	public String getUrl(int page) {
		return "/board/list?page=" + page;
	}
	
	public String getNextPageUrl() {
		return "/board/list?page=" + (endPage + 1);
	}
	
	public String getPrevPageUrl() {
		return "/board/list?page=" + (startPage - 1);
	}
}
