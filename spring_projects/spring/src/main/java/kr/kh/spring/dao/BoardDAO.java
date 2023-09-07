package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.LikeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.MemberVO;
import kr.kh.spring.vo.ViewVO;

public interface BoardDAO {

	boolean insertBoard(@Param("board") BoardVO board);

	List<BoardVO> selectBoardList(@Param("cri") Criteria cri);

	int selectBoardCount(@Param("cri") Criteria cri);

	BoardVO selectBoard(@Param("bo_num") Integer bo_num);

	void updateViews(@Param("bo_num") Integer bo_num);

	void insertFile(@Param("file") FileVO fileVo);

	List<FileVO> selectFileList(@Param("bo_num") Integer bo_num);

	void deleteBoard(@Param("bo_num") Integer bo_num);

	boolean updateBoard(@Param("board") BoardVO board);
	
	FileVO selectFile(@Param("fi_num")Integer num);

	void deleteFile(@Param("fi_num")Integer num);

	LikeVO selectLike(@Param("li_bo_num")int li_bo_num, @Param("li_me_id")String li_me_id);

	void insertLike(@Param("like")LikeVO likeVo);

	void updateLike(@Param("like")LikeVO likeVo);

	void updateBoardLike(@Param("bo_num")int li_bo_num);

	ViewVO selectViewcount(@Param("bo_num") Integer bo_num, @Param("user") MemberVO user);

	void insertViewCount(@Param("bo_num") Integer bo_num, @Param("user") MemberVO user);
	
	void deleteViewCount(@Param("bo_num") Integer bo_num, @Param("user") MemberVO user);

	void updateBoardComment(@Param("co_bo_num") int co_bo_num);

}
