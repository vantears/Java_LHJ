package kr.kh.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.LikeVO;
import kr.kh.spring.vo.MemberVO;

public interface BoardService {

	boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files);

	List<BoardVO> selectBoardList(Criteria cri);

	int getTotalCount(Criteria cri);

	BoardVO selectBoard(Integer bo_num);

	void updateViews(Integer bo_num, MemberVO user);

	List<FileVO> getFileList(Integer bo_num);

	boolean deleteBoard(Integer bo_num, MemberVO user);

	boolean updateBoard(BoardVO board, MultipartFile[] files, Integer[] delFiles, MemberVO user);

	int like(LikeVO likeVo);

	LikeVO getBoardLike(Integer bo_num, MemberVO user);

}
