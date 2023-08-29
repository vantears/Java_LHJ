package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("member") MemberVO member);

	MemberVO selectMember(@Param("me_id") String me_id);


}
