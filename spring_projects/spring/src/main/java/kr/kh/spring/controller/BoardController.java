package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;
import kr.kh.spring.util.Message;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.MemberVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model, Criteria cri, HttpSession session) {
		
		cri.setPerPageNum(3);
		List<BoardVO> list = boardService.selectBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		//페이지네이션에서 최대 페이지 개수
		int displayPageNum = 3;
		
		PageMaker pm = new PageMaker(totalCount, displayPageNum, cri);
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		model.addAttribute("user", user);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		
		return "/board/list";
	}
	
	@GetMapping("/insert")
	public String insert(HttpSession session, Model model) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user == null || user.getMe_id() == null) {
			Message msg = new Message("/board/list", "게시글 작성을 위해 로그인을 해주세요.");
			model.addAttribute("msg", msg);
			return "message";
		}
		return "/board/insert";
	}
	
	@PostMapping("/insert")
	public String insertPost(BoardVO board, HttpSession session, Model model) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.insertBoard(board, user)) {
			msg = new Message("board/list", "게시글을 등록했습니다.");
		} else {
			msg = new Message("board/insert", "게시글 등록에 실패했습니다.");
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, Integer bo_num, Criteria cri) {
		boardService.updateViews(bo_num);
		BoardVO board = boardService.selectBoard(bo_num);
		model.addAttribute("board", board);
		model.addAttribute("cri", cri);
		return "/board/detail";
	}


}
