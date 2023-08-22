package db.day3.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.day3.board.vo.BoardVO;

public interface BoardDAO {

	int insertBoard(@Param("board")BoardVO board);

	ArrayList<BoardVO> selectAllboard();

	BoardVO selectBoard(@Param("bo_num")int bo_num);

	int updateBoard(@Param("board")BoardVO dbBoard);

	void deleteBoard(@Param("bo_num")int bo_num);


}
