package db.day3.board.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.day3.board.dao.BoardDAO;
import db.day3.board.dao.MemberDAO;
import db.day3.board.vo.BoardVO;
import db.day3.board.vo.MemberVO;

public class BoardServiceImp implements BoardService{

	private BoardDAO boardDao;
	private MemberDAO memberDao;
	private final String MYBATIS_CONFIG_PATH = "db/day3/board/config/mybatis-config.xml";
	
	public BoardServiceImp() {
		try {
			InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			//true의 역할 : 쿼리(insert, update,delete) 실행 후 자동 커밋되게 해줌
			SqlSession session = sf.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean insertBoard(BoardVO board) {
		if(board == null || board.getBo_me_id() == null || board.getBo_title() == null) {
			return false;
		}
		MemberVO dbMember = memberDao.selectMember(board.getBo_me_id());
		if(dbMember == null) {
			return false;
		}
		if(boardDao.insertBoard(board) != 0) {
			memberDao.updateBoardCount(board.getBo_me_id());
			return true;
		}
		return false;
	}

	@Override
	public void selectAllBoard() {
		ArrayList<BoardVO> board = boardDao.selectAllboard();
		for(BoardVO tmp : board) {
			System.out.println(tmp);
		}
		
	}

	@Override
	public boolean updateBoard(BoardVO board) {
		if(board == null || board.getBo_title() == null) {
			return false;
		}
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		if(dbBoard == null) {
			return false;
		}
		dbBoard.setBo_title(board.getBo_title());
		if(boardDao.updateBoard(dbBoard) != 0) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean deleteBoard(BoardVO board, String pw) {
		if(board == null || board.getBo_me_id() == null) {
			return false;
		}
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		MemberVO dbMember = memberDao.selectMember(board.getBo_me_id());
		if(dbBoard != null && dbBoard.getBo_me_id().equals(board.getBo_me_id()) && dbMember.getMe_pw().equals(pw)) {
			boardDao.deleteBoard(dbBoard.getBo_num());
			memberDao.reduceBoardCount(board.getBo_me_id());
			return true;
		}
		return false;
	}

}
