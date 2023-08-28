package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.dao.MemberDAO;
import kr.kh.app.vo.BoardVO;
import kr.kh.app.vo.MemberVO;

public class BoardServiceImp implements BoardService {

	private BoardDAO boardDao;
	private MemberDAO memberDao;
	private final String MYBATIS_CONFIG_PATH = "kr/kh/app/config/mybatis-config.xml";
	
	public BoardServiceImp() {
		try {
			InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			//true�� ���� : ����(insert,update,delete) ���� �� �ڵ� Ŀ�Եǰ� ���� 
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
		//�ۼ��ڰ� ȸ���� �´��� Ȯ�� 
		MemberVO member = memberDao.selectMember(board.getBo_me_id());
		if(member == null) {
			return false;
		}
		boardDao.insertBoard(board);
		memberDao.updateBoardCount(board.getBo_me_id());
		return true;
	}
	
	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}

}