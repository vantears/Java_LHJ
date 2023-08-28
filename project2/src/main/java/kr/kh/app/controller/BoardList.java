package kr.kh.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;
import kr.kh.app.vo.BoardVO;

import java.io.IOException;
import java.util.List;

public class BoardList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImp();
	
    public BoardList() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� ������ ������ Criteria
		int page = 1;
		int perPageNum = 3;
		try {
			page = Integer.parseInt(request.getParameter("page"));
			page = page < 1 ? 1 : page;
		}catch(Exception e) {}
		Criteria cri = new Criteria(page, perPageNum);
		//��ü �Խñ� ��
		int totalCount = boardService.getTotalCount();
		//���������̼ǿ��� �ִ� ������ ����
		int displayPageNum = 3;
		
		PageMaker pm = new PageMaker(totalCount, displayPageNum, cri);
		
		List<BoardVO> list = boardService.getBoardList(cri);
		request.setAttribute("list", list);
		request.setAttribute("pm", pm);
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
