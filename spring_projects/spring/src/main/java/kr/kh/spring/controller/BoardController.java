package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;
import kr.kh.spring.util.Message;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.LikeVO;
import kr.kh.spring.vo.MemberVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model, Criteria cri, HttpSession session) {
		
		cri.setPerPageNum(6);
		List<BoardVO> list = boardService.selectBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		//페이지네이션에서 최대 페이지 개수
		int displayPageNum = 3;
		
		PageMaker pm = new PageMaker(displayPageNum, cri, totalCount);
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		model.addAttribute("user", user);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		
		return "/board/list";
	}
	
	@GetMapping("/insert")
	public String insert(HttpSession session, Model model, Integer bo_ori_num) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user == null || user.getMe_id() == null) {
			Message msg = new Message("/board/list", "Please log in first to post");
			model.addAttribute("msg", msg);
			return "message";
		}
		model.addAttribute("bo_ori_num", bo_ori_num == null ? 0 : bo_ori_num);
		return "/board/insert";
	}
	
	@PostMapping("/insert")
	public String insertPost(BoardVO board, HttpSession session, Model model, MultipartFile[] files) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.insertBoard(board, user, files)) {
			msg = new Message("board/list", "Posted successfully");
		} else {
			msg = new Message("board/insert", "Failed to post");
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, Integer bo_num, Criteria cri, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user != null && user.getMe_id() != null) {
			boardService.updateViews(bo_num, user);			
		}
		BoardVO board = boardService.selectBoard(bo_num);
		List<FileVO> fileList = boardService.getFileList(bo_num);
		LikeVO like = boardService.getBoardLike(bo_num, user);
		board.setFileVoList(fileList);
		model.addAttribute("board", board);
		model.addAttribute("cri", cri);
		model.addAttribute("user", user);
		model.addAttribute("like", like);
		return "/board/detail";
	}
	
	@GetMapping("/update")
	public String update(Model model,Integer bo_num, HttpSession session) {
		BoardVO board = boardService.selectBoard(bo_num);
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user == null || board == null || !user.getMe_id().equals(board.getBo_me_id())) {
			Message msg = new Message("/board/list", "Wrong access");
			model.addAttribute("msg", msg);
			return "message";
		}
		model.addAttribute("board", board);
		return "/board/update";
	}
	
	@PostMapping("/update")
	public String updatePost(Model model, BoardVO board, 
			MultipartFile[] files, Integer[] delFiles, HttpSession session) {
		Message msg;
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(boardService.updateBoard(board, files, delFiles, user)) {
			msg = new Message("/board/detail?bo_num="+board.getBo_num(), "Edited successfully");
		}else {
			msg = new Message("/board/update?bo_num="+board.getBo_num(), "Failed to edit"); 
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	
	@GetMapping("/delete")
	public String delete(Integer bo_num, HttpSession session, Model model) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.deleteBoard(bo_num, user)) {
			msg = new Message("board/list", "Deleted successfully");
		} else {
			msg = new Message("board/list", "Wrong access");
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	
	@ResponseBody
	@PostMapping("/like")
	public Map<String, Object> ajaxTest(@RequestBody LikeVO likeVo){
		Map<String, Object> map = new HashMap<String, Object>();
		//추천 : 1, 비추천 : -1, 취소: 0
		int res = boardService.like(likeVo);
		BoardVO board = boardService.selectBoard(likeVo.getLi_bo_num());
		map.put("res", res);
		map.put("board", board);
		return map;
	}

}
