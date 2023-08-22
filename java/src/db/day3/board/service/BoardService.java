package db.day3.board.service;

import db.day3.board.vo.BoardVO;

public interface BoardService {

	boolean insertBoard(BoardVO board);

	void selectAllBoard();

	boolean updateBoard(BoardVO board);

	boolean deleteBoard(BoardVO board, String pw);

}
