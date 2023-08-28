package kr.kh.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;
import kr.kh.app.vo.BoardVO;

import java.io.IOException;

public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();
    public BoardDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer bo_num;
		try {
			bo_num = Integer.parseInt(request.getParameter("bo_num"));
		}catch(Exception e) {
			bo_num = null;
		}
		BoardVO board = boardService.getBoard(bo_num);
		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
