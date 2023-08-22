package db.day3.board.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.day3.board.dao.MemberDAO;
import db.day3.board.vo.MemberVO;

public class MemberServiceImp implements MemberService {
	
	private MemberDAO memberDao;
	private final String MYBATIS_CONFIG_PATH = "db/day3/board/config/mybatis-config.xml";
	
	public MemberServiceImp() {
		try {
			InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			//true의 역할 : 쿼리(insert, update,delete) 실행 후 자동 커밋되게 해줌
			SqlSession session = sf.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signup(MemberVO member) {
		if(member == null || member.getMe_id() == null) {
			return false;
		}
		//아이디 중복 체크 => 아이디와 일치하는 회원 정보를 조회해서 가져옴
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//아이디가 중복되지 않으면 회원가입을 진행 => 일치하는 회원정보가 없으면 
		if(dbMember == null) {
			memberDao.insertMember(member);
			return true;
		}
		return false;
	}

	@Override
	public boolean dismiss(MemberVO member) {
		if(member == null || member.getMe_id() == null) {
			return false;
		}
		//아이디를 이용하여 회원 정보를 가져옴
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		if(dbMember != null && dbMember.getMe_pw().equals(member.getMe_pw())) {
			memberDao.deleteMember(member.getMe_id());
			return true;
		}
		return false;
	}

}
