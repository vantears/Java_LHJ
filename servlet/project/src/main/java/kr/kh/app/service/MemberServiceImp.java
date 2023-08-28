package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.vo.MemberVO;

public class MemberServiceImp implements MemberService {
	
	private MemberDAO memberDao;
	private final String MYBATIS_CONFIG_PATH = "kr/kh/app/config/mybatis-config.xml";
	
	public MemberServiceImp() {
		try {			
			InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			//true�� ���� : ����(insert,update,delete) ���� �� �ڵ� Ŀ�Եǰ� ���� 
			SqlSession session = sf.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signup(MemberVO member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null) {
			return false;
		}
		//���̵� �ߺ� Ȯ��
		//���̵� ��ġ�ϴ� ȸ�� ������ ������ 
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//ȸ�� ������ ������ => ���̵� �ߺ�
		if(dbMember != null) {
			return false;
		}
		memberDao.insertMember(member);
		return true;
	}

	@Override
	public boolean withdraw(MemberVO member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null) {
			return false;
		}
		//���̵� ��ġ�ϴ� ȸ�� ������ ������ 
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//ȸ�� ������ ������ Ż�� �Ұ���
		if(dbMember == null) {
			return false;
		}
		//����� ��ġ���� ������
		if(!dbMember.getMe_pw().equals(member.getMe_pw())) {
			return false;
		}
		memberDao.deleteMember(member.getMe_id());
		return true;
	}


}