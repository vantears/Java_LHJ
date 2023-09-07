package kr.kh.spring.pagination;

import lombok.Data;

@Data
public class PageMaker {

	private int startPage; 
	private int endPage; 
	private boolean prev; 
	private boolean next; 
	private int displayPageNum;
	private Criteria cri;
	private int totalCount;
	
	
	public void calculate() {
		
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		
		startPage = endPage - displayPageNum + 1;
		
		int lastEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));
		
		if(endPage > lastEndPage) {
			endPage = lastEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage == lastEndPage ? false : true;
	}
	
	public PageMaker(int displayPageNum, Criteria cri, int totalCount) {
		this.totalCount = totalCount;
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		calculate();
	}
	
}
