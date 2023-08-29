package kr.kh.spring.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		if(dbMember != null) {
			return false;
		}
		if(member.getMe_id() == null || member.getMe_pw() == null) {
			return false;
		}
		String idRegex = "^[a-zA-Z][a-zA-Z0-9]{5,14}$";
		String pwRegex = "^[a-zA-Z0-9!@#$%]{6,15}$";
		
		if(!Pattern.matches(idRegex, member.getMe_id()) || !Pattern.matches(pwRegex, member.getMe_pw())) {
			return false;
		}
		
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		
		return memberDao.insertMember(member);
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		if(member.getMe_id() == null || member.getMe_pw() == null) {
			return null;
		}
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		
		if(dbMember == null) {
			return null;
		}
		if(passwordEncoder.matches(member.getMe_pw(), dbMember.getMe_pw())) {
			return dbMember;
		}
		return null;
	}

	

	
}
